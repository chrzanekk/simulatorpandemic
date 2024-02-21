package com.chrzanekk.simulatorpandemic.domain

import jakarta.persistence.*

@Entity
@Table(name = "simulated_population")
data class SimulatedPopulation(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "no_of_infected_ppl")
    val numberOfInfectedPeople: Int,

    @Column(name = "no_of_healthy_susceptible_for_infection")
    val numberOfHealthySusceptibleForInfection: Int,

    @Column(name = "no_of_deaths")

    val numberOfDeaths: Int,
    @Column(name = "no_of_cured_and_immune")
    val numberOfCuredAndImmune: Int,

    @JoinColumn(name = "simulation_id")
    @ManyToOne
    val simulation: Simulation
)
