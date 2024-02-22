package com.chrzanekk.simulatorpandemic.service.impl

import com.chrzanekk.simulatorpandemic.payload.NewSimulationRequest
import com.chrzanekk.simulatorpandemic.payload.NewSimulationResponse
import com.chrzanekk.simulatorpandemic.repository.SimulationRepository
import com.chrzanekk.simulatorpandemic.service.SimulationService
import org.springframework.stereotype.Service

@Service
class SimulationServiceImpl(private val simulationRepository: SimulationRepository): SimulationService  {
    override fun createSimulation(newSimulationRequest: NewSimulationRequest): NewSimulationResponse {
        TODO("Not yet implemented")
    }

    override fun findAllSimulations() {
        TODO("Not yet implemented")
    }
}