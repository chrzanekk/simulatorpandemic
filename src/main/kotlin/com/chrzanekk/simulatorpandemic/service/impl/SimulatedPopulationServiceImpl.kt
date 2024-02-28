package com.chrzanekk.simulatorpandemic.service.impl

import com.chrzanekk.simulatorpandemic.domain.SimulatedPopulation
import com.chrzanekk.simulatorpandemic.domain.Simulation
import com.chrzanekk.simulatorpandemic.exception.SimulatedPopulationException
import com.chrzanekk.simulatorpandemic.repository.SimulatedPopulationRepository
import com.chrzanekk.simulatorpandemic.service.SimulatedPopulationService
import com.chrzanekk.simulatorpandemic.service.dto.SimulatedPopulationDTO
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.jvm.Throws

@Service
class SimulatedPopulationServiceImpl(private val simulatedPopulationRepository: SimulatedPopulationRepository) :
    SimulatedPopulationService {
    @Throws(SimulatedPopulationException::class)
    override fun createSimulatedPopulations(simulation: Simulation): List<SimulatedPopulationDTO> {
        val firstSimulatedPopulation = SimulatedPopulation(
            0L,
            simulation.initialNoOfInfectedPpl,
            simulation.populationSize.subtract(simulation.initialNoOfInfectedPpl),
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            simulation
        )
        val firstSavedSimulatedPopulation = simulatedPopulationRepository.save(firstSimulatedPopulation)

        var simulatedPopulationList = listOf(firstSavedSimulatedPopulation.toDTO())
        simulatedPopulationList = simulatePopulations(simulatedPopulationList, simulation)
        return simulatedPopulationList
    }

    private fun simulatePopulations(
        simulatedPopulationList: List<SimulatedPopulationDTO>,
        simulation: Simulation
    ): List<SimulatedPopulationDTO> {
        var mutableSimulatedPopulationList = simulatedPopulationList
        var dayOfSimulation = 1;

        do {
            val previousSimulatedPopulation = mutableSimulatedPopulationList[dayOfSimulation - 1]
            val infected = calculateInfectedPpl(simulation, previousSimulatedPopulation)
            val dead = calculateDeadPpl(simulation, mutableSimulatedPopulationList, dayOfSimulation)
            val immune = calculateImmunePpl(simulation, mutableSimulatedPopulationList, dead, dayOfSimulation)
            val healthySusceptibleForInfection =
                simulation.populationSize.subtract(infected).subtract(immune).subtract(dead)
            val isPopulationCountIsCorrect = checkIfSumOfFourGroupsEqualsBasicPopulationSize(
                infected, dead, immune,
                healthySusceptibleForInfection, simulation.populationSize
            )
            mutableSimulatedPopulationList = validatePopulationCount(
                isPopulationCountIsCorrect,
                infected,
                healthySusceptibleForInfection,
                dead,
                immune,
                simulation,
                mutableSimulatedPopulationList
            )
            dayOfSimulation++
        } while (dayOfSimulation <= simulation.simulationDays)
        return mutableSimulatedPopulationList
    }

    private fun validatePopulationCount(
        isPopulationCountIsCorrect: Boolean,
        infected: BigDecimal,
        healthySusceptibleForInfection: BigDecimal,
        dead: BigDecimal,
        immune: BigDecimal,
        simulation: Simulation,
        simulatedPopulationList: List<SimulatedPopulationDTO>
    ): List<SimulatedPopulationDTO> {
        if (isPopulationCountIsCorrect) {
            val newSimulatedPopulation = SimulatedPopulation(
                0L, infected, healthySusceptibleForInfection, dead,
                immune, simulation
            )
            val savedNewSimulatedPopulation = simulatedPopulationRepository.save(newSimulatedPopulation)
            simulatedPopulationList.plus(savedNewSimulatedPopulation.toDTO())
            return simulatedPopulationList
        } else {
            throw SimulatedPopulationException("Something go wrong")
        }
    }

    private fun checkIfSumOfFourGroupsEqualsBasicPopulationSize(
        infected: BigDecimal,
        dead: BigDecimal,
        immune: BigDecimal,
        healthySusceptibleForInfection: BigDecimal,
        populationSize: BigDecimal
    ): Boolean {
        return infected.add(dead).add(immune).add(healthySusceptibleForInfection) >= populationSize
    }

    private fun calculateImmunePpl(
        simulation: Simulation,
        simulatedPopulationList: List<SimulatedPopulationDTO>,
        dead: BigDecimal,
        dayOfSimulation: Int
    ): BigDecimal {
        if (dayOfSimulation <= simulation.infectedToCureDuration) {
            return BigDecimal.ZERO
        } else {
            val indexOfInfected = simulatedPopulationList.lastIndex - simulation.infectedToCureDuration
            val baseSimulatedPopulation = simulatedPopulationList[indexOfInfected]
            return baseSimulatedPopulation.numberOfInfectedPeople.subtract(dead).setScale(0, RoundingMode.UP)
        }
    }

    private fun calculateDeadPpl(
        simulation: Simulation,
        simulatedPopulationList: List<SimulatedPopulationDTO>,
        dayOfSimulation: Int
    ): BigDecimal {
        if (dayOfSimulation <= simulation.infectedToDeathDuration) {
            return BigDecimal.ZERO
        } else {
            val indexOfInfected = simulatedPopulationList.lastIndex - simulation.infectedToDeathDuration
            val baseSimulatedPopulation = simulatedPopulationList[indexOfInfected]
            return baseSimulatedPopulation.numberOfHealthySusceptibleForInfection.multiply(simulation.mortalityRate)
                .setScale(0, RoundingMode.UP)
        }
    }

    private fun calculateInfectedPpl(
        simulation: Simulation,
        previousSimulatedPopulation: SimulatedPopulationDTO
    ): BigDecimal {
        return simulation.infectionRate.multiply(previousSimulatedPopulation.numberOfHealthySusceptibleForInfection)
            .setScale(0, RoundingMode.UP)
    }

    override fun findAllSimulatedPopulationsBySimulationId(simulationId: Long): List<SimulatedPopulationDTO> {
        TODO("Not yet implemented")
    }
}