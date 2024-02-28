package com.chrzanekk.simulatorpandemic.payload

import com.chrzanekk.simulatorpandemic.domain.SimulatedPopulation
import java.math.BigDecimal

data class NewSimulationResponse(
    val simulationName: String,
    val populationSize: BigDecimal,
    val initialNoOfInfectedPpl: BigDecimal,
    val infectionRate: BigDecimal,
    val mortalityRate: BigDecimal,
    val infectedToCureDuration: Int,
    val infectedToDeathDuration: Int,
    val simulationDays: Int,
    val simulatedPopulation: List<SimulatedPopulation>
)
