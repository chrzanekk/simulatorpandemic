package com.chrzanekk.simulatorpandemic.service.impl

import com.chrzanekk.simulatorpandemic.domain.Simulation
import com.chrzanekk.simulatorpandemic.payload.NewSimulationRequest
import com.chrzanekk.simulatorpandemic.payload.NewSimulationResponse
import com.chrzanekk.simulatorpandemic.repository.SimulationRepository
import com.chrzanekk.simulatorpandemic.service.SimulationService
import org.springframework.stereotype.Service

@Service
class SimulationServiceImpl(private val simulationRepository: SimulationRepository): SimulationService  {
    override fun createSimulation(newSimulationRequest: NewSimulationRequest): NewSimulationResponse {
        val simulationToSave = Simulation(
            0L,
            newSimulationRequest.simulationName,
            newSimulationRequest.populationSize,
            newSimulationRequest.initialNoOfInfectedPpl,
            newSimulationRequest.infectionRate,
            newSimulationRequest.mortalityRate,
            newSimulationRequest.infectedToCureDuration,
            newSimulationRequest.infectedToDeathDuration,
            newSimulationRequest.simulationDays)
        val savedSimulation = simulationRepository.save(simulationToSave)


        return NewSimulationResponse(savedSimulation.simulationName,
            savedSimulation.populationSize,
            savedSimulation.initialNoOfInfectedPpl,
            savedSimulation.infectionRate,
            savedSimulation.mortalityRate,
            savedSimulation.infectedToCureDuration,
            savedSimulation.infectedToDeathDuration,
            savedSimulation.simulationDays,
            mutableListOf()
        )
    }

    override fun findAllSimulations() {
        TODO("Not yet implemented")
    }
}