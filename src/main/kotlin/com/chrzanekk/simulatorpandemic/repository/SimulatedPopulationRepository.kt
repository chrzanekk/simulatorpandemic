package com.chrzanekk.simulatorpandemic.repository

import com.chrzanekk.simulatorpandemic.domain.SimulatedPopulation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SimulatedPopulationRepository : JpaRepository<SimulatedPopulation, Long>