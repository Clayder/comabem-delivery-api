package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "permission_group")
data class PermissionGroupModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var name: String,

    @ManyToMany
    @JoinTable(name = "permission_group_permission_type",
        joinColumns = [JoinColumn(name = "permission_group_id")],
        inverseJoinColumns = [JoinColumn(name = "permission_type_id")])
    var permissionType: List<PermissionTypeModel>
)