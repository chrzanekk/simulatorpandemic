package com.chrzanekk.simulatorpandemic.service.dto

import com.chrzanekk.simulatorpandemic.domain.SimulatedPopulation
import com.sun.jdi.IntegerValue
import java.math.BigDecimal

data class SimulationDTO(val id: Long,
                         val simulationName: String,
                         val populationSize: BigDecimal,
                         val initialNoOfInfectedPpl: BigDecimal,
                         val infectionRate: BigDecimal,
                         val mortalityRate: BigDecimal,
                         val infectedToCureDuration: Int,
                         val infectedToDeathDuration: Int,
                         val simulationDays: Int,
                         val simulatedPopulation: List<SimulatedPopulationDTO>)
