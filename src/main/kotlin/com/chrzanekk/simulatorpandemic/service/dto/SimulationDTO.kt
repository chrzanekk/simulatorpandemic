package com.chrzanekk.simulatorpandemic.service.dto

import com.chrzanekk.simulatorpandemic.domain.SimulatedPopulation
import java.math.BigDecimal

data class SimulationDTO(val id: Long,
                         val simulationName: String,
                         val populationSize: BigDecimal,
                         val initialNoOfInfectedPpl: BigDecimal,
                         val infectionRate: BigDecimal,
                         val mortalityRate: BigDecimal,
                         val infectedToCureDuration: BigDecimal,
                         val infectedToDeathDuration: BigDecimal,
                         val simulationDays: BigDecimal,
                         val simulatedPopulation: List<SimulatedPopulationDTO>)
