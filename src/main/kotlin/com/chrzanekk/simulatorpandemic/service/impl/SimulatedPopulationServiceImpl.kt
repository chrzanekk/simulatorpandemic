package com.chrzanekk.simulatorpandemic.service.impl

import com.chrzanekk.simulatorpandemic.repository.SimulatedPopulationRepository
import com.chrzanekk.simulatorpandemic.service.SimulatedPopulationService
import com.chrzanekk.simulatorpandemic.service.dto.SimulatedPopulationDTO
import org.springframework.stereotype.Service

@Service
class SimulatedPopulationServiceImpl(simulatedPopulationRepository: SimulatedPopulationRepository) :SimulatedPopulationService {
    override fun findAllSimulatedPopulationsBySimulationId(simulationId: Long): List<SimulatedPopulationDTO> {
        TODO("Not yet implemented")
    }
}