package com.clayder.api.comabemdelivery.domain.repository

import com.clayder.api.comabemdelivery.domain.model.PermissionTypeModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PermissionRepository: JpaRepository<PermissionTypeModel, Long> {
}