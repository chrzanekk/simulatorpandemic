package com.chrzanekk.simulatorpandemic.repository

import com.chrzanekk.simulatorpandemic.domain.Simulation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SimulationRepository : JpaRepository<Simulation, Long>