package com.clayder.api.comabemdelivery.domain.service

import com.clayder.api.comabemdelivery.domain.exception.EntityInUseException
import com.clayder.api.comabemdelivery.domain.exception.EntityNotFoundException
import com.clayder.api.comabemdelivery.domain.model.PermissionModel
import com.clayder.api.comabemdelivery.domain.repository.PermissionRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class PermissionService(private val repository: PermissionRepository) {

    fun findAll(): List<PermissionModel> {
        return repository.findAll()
    }

    fun getById(id: Long): PermissionModel {
        val model = repository.findById(id)

        if(model.isEmpty) {
            throw EntityNotFoundException("State $id not found.")
        }

        return model.get()
    }

    fun create(newModel: PermissionModel): PermissionModel {
        return repository.save(newModel)
    }

    fun update(updateModel: PermissionModel, id: Long): PermissionModel {
        val model = getById(id)
        updateModel.id = model.id
        return repository.save(updateModel)
    }

    fun delete(id: Long) {

        try {
            repository.deleteById(id)
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException("Permission $id cannot be removed as it is in use")
        }
    }
}