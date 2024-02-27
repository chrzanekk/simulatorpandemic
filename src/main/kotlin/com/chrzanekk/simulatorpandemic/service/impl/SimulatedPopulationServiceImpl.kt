package com.chrzanekk.simulatorpandemic.service.impl

import com.chrzanekk.simulatorpandemic.domain.SimulatedPopulation
import com.chrzanekk.simulatorpandemic.domain.Simulation
import com.chrzanekk.simulatorpandemic.repository.SimulatedPopulationRepository
import com.chrzanekk.simulatorpandemic.service.SimulatedPopulationService
import com.chrzanekk.simulatorpandemic.service.dto.SimulatedPopulationDTO
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class SimulatedPopulationServiceImpl(private val simulatedPopulationRepository: SimulatedPopulationRepository) :
    SimulatedPopulationService {

    override fun createSimulatedPopulations(simulation: Simulation): List<SimulatedPopulationDTO> {
        val firstSimulatedPopulation = SimulatedPopulation(
            0L,
            simulation.initialNoOfInfectedPpl,
            simulation.populationSize.subtract(simulation.initialNoOfInfectedPpl),
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            simulation
        )
        val firstSavedSimulatedPopulation = simulatedPopulationRepository.save(firstSimulatedPopulation)

//TODO implement algorithm to calculate population
        return mutableListOf()
    }

    override fun findAllSimulatedPopulationsBySimulationId(simulationId: Long): List<SimulatedPopulationDTO> {
        TODO("Not yet implemented")
    }
}