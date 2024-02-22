package com.chrzanekk.simulatorpandemic.service

import com.chrzanekk.simulatorpandemic.service.dto.SimulatedPopulationDTO

interface SimulatedPopulationService {

    fun findAllSimulatedPopulationsBySimulationId(simulationId: Long): List<SimulatedPopulationDTO>
}