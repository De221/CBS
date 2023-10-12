package com.example.CBS.Entities

import jakarta.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDateTime
import java.util.*


@Entity
data class Customer
(
    @Column(nullable = false)
    var fullName: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    @JvmField
    var password: String
)
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : UUID  = UUID.randomUUID()

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: Status = Status.ACTIVE

    @Column(nullable = false)
    val created: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    var updated: LocalDateTime = LocalDateTime.now()

    fun SetPassword(value: String)
    {
        val passwordEncoder = BCryptPasswordEncoder()
        password = passwordEncoder.encode(value)
    }
    fun comparePassword(password: String): Boolean{
        return BCryptPasswordEncoder().matches(password, this.password)
    }

}
    enum class Status {
        ACTIVE,
        DEACTIVATED
    }