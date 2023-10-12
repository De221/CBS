package com.example.CBS.Repositories

import com.example.CBS.Entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CustomerRepository: JpaRepository<Customer, UUID>{

    fun findByEmail(email: String): Customer?
}