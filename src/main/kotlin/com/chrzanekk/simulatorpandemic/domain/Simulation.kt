package com.chrzanekk.simulatorpandemic.domain

import jakarta.persistence.*

@Entity
@Table(name = "simulation")
data class Simulation(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "simulation_name")
    val simulationName: String,

    @Column(name = "population_size")
    val populationSize: Int,

    @Column(name = "initial_no_of_infected_ppl")
    val initialNoOfInfectedPpl: Int,

    @Column(name = "infection_rade")
    val infectionRate: Float,

    @Column(name = "mortality_rate")
    val mortalityRate: Float,

    @Column(name = "infected_to_cure_duration")
    val infectedToCureDuration: Int,

    @Column(name = "infected_to_death_duration")
    val infectedToDeathDuration: Int,

    @Column(name = "days_of_simulation")
    val simulationDays: Int
)