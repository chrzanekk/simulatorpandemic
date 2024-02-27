package com.chrzanekk.simulatorpandemic.domain

import com.chrzanekk.simulatorpandemic.service.dto.SimulationDTO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "simulation")
data class Simulation(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "simulation_name")
    val simulationName: String,

    @Column(name = "population_size")
    val populationSize: BigDecimal,

    @Column(name = "initial_no_of_infected_ppl")
    val initialNoOfInfectedPpl: BigDecimal,

    @Column(name = "infection_rade")
    val infectionRate: BigDecimal,

    @Column(name = "mortality_rate")
    val mortalityRate: BigDecimal,

    @Column(name = "infected_to_cure_duration")
    val infectedToCureDuration: BigDecimal,

    @Column(name = "infected_to_death_duration")
    val infectedToDeathDuration: BigDecimal,

    @Column(name = "days_of_simulation")
    val simulationDays: BigDecimal
) {
    fun toDTO() = SimulationDTO(
        id,
        simulationName,
        populationSize,
        initialNoOfInfectedPpl,
        infectionRate,
        mortalityRate,
        infectedToCureDuration,
        infectedToDeathDuration,
        simulationDays,
        mutableListOf()
    )
}