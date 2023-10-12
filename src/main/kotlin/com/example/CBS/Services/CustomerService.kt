package com.example.CBS.Services

import com.example.CBS.Entities.Customer
import com.example.CBS.Repositories.CustomerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(private val customerRepo: CustomerRepository) {
    fun save(customer: Customer): Customer {
        return this.customerRepo.save(customer)
    }

    fun findByEmail(email: String) : Customer?{
        return this.customerRepo.findByEmail(email)
    }

    fun findById(id: UUID): Optional<Customer> {
        return this.customerRepo.findById(id)
    }

}