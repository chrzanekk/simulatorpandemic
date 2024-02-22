package com.chrzanekk.simulatorpandemic.service.dto

data class SimulatedPopulationDTO(
    val id: Long,
    val numberOfInfectedPeople: Int,
    val numberOfHealthySusceptibleForInfection: Int,
    val numberOfDeaths: Int,
    val numberOfCuredAndImmune: Int,
    val simulationId: Long
)
