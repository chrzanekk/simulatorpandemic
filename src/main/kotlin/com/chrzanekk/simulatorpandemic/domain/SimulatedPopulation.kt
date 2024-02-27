package com.chrzanekk.simulatorpandemic.domain

import com.chrzanekk.simulatorpandemic.service.dto.SimulatedPopulationDTO
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "simulated_population")
data class SimulatedPopulation(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "no_of_infected_ppl")
    val numberOfInfectedPeople: BigDecimal,

    @Column(name = "no_of_healthy_susceptible_for_infection")
    val numberOfHealthySusceptibleForInfection: BigDecimal,

    @Column(name = "no_of_deaths")
    val numberOfDeaths: BigDecimal,

    @Column(name = "no_of_cured_and_immune")
    val numberOfCuredAndImmune: BigDecimal,

    @JoinColumn(name = "simulation_id")
    @ManyToOne
    val simulation: Simulation
) {
    fun toDTO() = SimulatedPopulationDTO(
        id,
        numberOfInfectedPeople,
        numberOfHealthySusceptibleForInfection,
        numberOfDeaths,
        numberOfCuredAndImmune,
        simulation.id
    )
}
