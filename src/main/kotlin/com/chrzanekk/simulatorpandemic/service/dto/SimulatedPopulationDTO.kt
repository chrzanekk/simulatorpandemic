package com.chrzanekk.simulatorpandemic.service.dto

import java.math.BigDecimal

data class SimulatedPopulationDTO(
    val id: Long,
    val numberOfInfectedPeople: BigDecimal,
    val numberOfHealthySusceptibleForInfection: BigDecimal,
    val numberOfDeaths: BigDecimal,
    val numberOfCuredAndImmune: BigDecimal,
    val simulationId: Long
)
