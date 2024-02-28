package com.chrzanekk.simulatorpandemic.unit

import com.chrzanekk.simulatorpandemic.domain.Simulation
import com.chrzanekk.simulatorpandemic.repository.SimulationRepository
import com.chrzanekk.simulatorpandemic.util.postgres
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.math.BigDecimal

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimulationRepositoryTest {

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
        val simulationList = simulationRepository.findAll();

        //then
        assertEquals(simulationList.size, 3)
    }

    @Test
    fun checkIfDataIsSavedCorrectlyInDB() {
        //given
        val newSimulation = Simulation(
            0L, "NewSimulation", BigDecimal(15000), BigDecimal(25), BigDecimal(1.2),
            BigDecimal(0.9),
            11,
            22, 120
        )

        //when

        simulationRepository.save(newSimulation)

        //then

        val simulationList = simulationRepository.findAll();

        assertEquals(simulationList.size, 4)

    }
}