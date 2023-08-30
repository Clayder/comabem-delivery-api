package com.clayder.api.comabemdelivery.domain.repository

import com.clayder.api.comabemdelivery.domain.model.CityModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository: JpaRepository<CityModel, Long> {
}