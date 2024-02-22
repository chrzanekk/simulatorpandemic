package com.chrzanekk.simulatorpandemic.service.dto

import com.chrzanekk.simulatorpandemic.domain.SimulatedPopulation

data class SimulationDTO(val simulationName: String,
                         val populationSize: Int,
                         val initialNoOfInfectedPpl: Int,
                         val infectionRate: Float,
                         val mortalityRate: Float,
                         val infectedToCureDuration: Int,
                         val infectedToDeathDuration: Int,
                         val simulationDays: Int,
                         val simulatedPopulation: List<SimulatedPopulationDTO>)
