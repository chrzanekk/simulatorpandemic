package com.chrzanekk.simulatorpandemic.service

import com.chrzanekk.simulatorpandemic.payload.NewSimulationRequest
import com.chrzanekk.simulatorpandemic.payload.NewSimulationResponse

interface SimulationService {

    fun createSimulation(newSimulationRequest: NewSimulationRequest) : NewSimulationResponse

    fun findAllSimulations()

}