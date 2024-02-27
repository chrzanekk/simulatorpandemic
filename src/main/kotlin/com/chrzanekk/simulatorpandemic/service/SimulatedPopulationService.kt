package com.chrzanekk.simulatorpandemic.service

import com.chrzanekk.simulatorpandemic.domain.Simulation
import com.chrzanekk.simulatorpandemic.service.dto.SimulatedPopulationDTO

interface SimulatedPopulationService {

    fun createSimulatedPopulations(simulation: Simulation) : List<SimulatedPopulationDTO>

    fun findAllSimulatedPopulationsBySimulationId(simulationId: Long): List<SimulatedPopulationDTO>
}