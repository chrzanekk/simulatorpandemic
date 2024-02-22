package com.chrzanekk.simulatorpandemic.unit

import com.chrzanekk.simulatorpandemic.domain.SimulatedPopulation
import com.chrzanekk.simulatorpandemic.repository.SimulatedPopulationRepository
import com.chrzanekk.simulatorpandemic.repository.SimulationRepository
import com.chrzanekk.simulatorpandemic.util.postgres
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimulatedPopulationRepositoryTest {

    @Autowired
    private lateinit var simulatedPopulationRepository: SimulatedPopulationRepository

    @Autowired
    private lateinit var simulationRepository: SimulationRepository


    companion object {

        @Container
        val container = postgres("12") {
            withDatabaseName("db")
            withUsername("user")
            withPassword("password")
            withInitScript("schema.sql")
        }

        @DynamicPropertySource
        @JvmStatic
        fun registerDynamicProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", container::getJdbcUrl)
            registry.add("spring.datasource.username", container::getUsername)
            registry.add("spring.datasource.password", container::getPassword)
        }
    }

    @Test
    fun containerIsUpAndRunning() {
        Assertions.assertTrue(container.isRunning)
    }

    @Test
    fun checkIfAnyDataIsStoredInDB() {

        //when
        val simulatedPopulationList = simulatedPopulationRepository.findAll();

        //then
        Assertions.assertEquals(simulatedPopulationList.size, 3)
    }

    @Test
    fun checkIfDataIsSavedCorrectlyInDB() {
        //given

        val simulation = simulationRepository.findById(1L).get()
        val newSimulatedPopulation = SimulatedPopulation(0L, 200, 50, 10, 25, simulation)

        //when

        simulatedPopulationRepository.save(newSimulatedPopulation)

        //then

        val simulationList = simulationRepository.findAll();
        val simulatedPopulationList = simulatedPopulationRepository.findAll()

        Assertions.assertEquals(simulationList.size, 3)
        Assertions.assertEquals(simulatedPopulationList.size, 4)

    }
}