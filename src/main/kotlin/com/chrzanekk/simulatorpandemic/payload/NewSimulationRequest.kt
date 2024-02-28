package com.chrzanekk.simulatorpandemic.payload

import java.math.BigDecimal

data class NewSimulationRequest(
    val simulationName: String,
    val populationSize: BigDecimal,
    val initialNoOfInfectedPpl: BigDecimal,
    val infectionRate: BigDecimal,
    val mortalityRate: BigDecimal,
    val infectedToCureDuration: Int,
    val infectedToDeathDuration: Int,
    val simulationDays: Int
)
