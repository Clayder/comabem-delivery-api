package com.clayder.api.comabemdelivery.domain.service

import com.clayder.api.comabemdelivery.domain.exception.EntityInUseException
import com.clayder.api.comabemdelivery.domain.exception.EntityNotFoundException
import com.clayder.api.comabemdelivery.domain.model.TypePaymentModel
import com.clayder.api.comabemdelivery.domain.repository.TypePaymentRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class TypePaymentService(private val repository: TypePaymentRepository) {

    fun findAll(): List<TypePaymentModel> {
        return repository.findAll()
    }

    fun getById(id: Long): TypePaymentModel {
        val model = repository.findById(id)

        if(model.isEmpty) {
            throw EntityNotFoundException("State $id not found.")
        }

        return model.get()
    }

    fun create(newModel: TypePaymentModel): TypePaymentModel {
        return repository.save(newModel)
    }

    fun update(updateModel: TypePaymentModel, id: Long): TypePaymentModel {
        val model = getById(id)
        updateModel.id = model.id
        return repository.save(updateModel)
    }

    fun delete(id: Long): Unit {
        try {
            repository.deleteById(id)
        } catch (e: DataIntegrityViolationException) {
            throw EntityInUseException("TypePayment $id cannot be removed as it is in use")
        }
    }
}