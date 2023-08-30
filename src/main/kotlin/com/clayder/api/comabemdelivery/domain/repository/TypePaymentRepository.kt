package com.clayder.api.comabemdelivery.domain.repository

import com.clayder.api.comabemdelivery.domain.model.TypePaymentModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TypePaymentRepository: JpaRepository<TypePaymentModel, Long> {
}