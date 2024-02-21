package com.chrzanekk.simulatorpandemic.payload

data class NewSimulationRequest(
    val simulationName: String,
    val populationSize: Int,
    val initialNoOfInfectedPpl: Int,
    val infectionRate: Float,
    val mortalityRate: Float,
    val infectedToCureDuration: Int,
    val infectedToDeathDuration: Int,
    val simulationDays: Int
)
