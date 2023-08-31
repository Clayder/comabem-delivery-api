package com.clayder.api.comabemdelivery.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "user")
data class UserModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var name: String,

    var email: String,

    var password: String,

    @CreationTimestamp
    @Column(nullable = false)
    var createdAt: LocalDateTime,

    @ManyToMany
    @JoinTable(name = "user_permission_group",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "permission_group_id")])
    var permissionGroups: List<PermissionGroupModel> = ArrayList()
)