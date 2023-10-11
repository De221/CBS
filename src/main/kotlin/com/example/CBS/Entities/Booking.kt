package com.example.CBS.Entities

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
data class Booking(
        @Column(nullable = false)
        val title: String,

        @Column(nullable = false)
        val description: String,
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : UUID  = UUID.randomUUID()

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: BookingStatus = BookingStatus.ACTIVE

    @Column(nullable = false)
    val recordCreated: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    val recordUpdated: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    val startDate: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    val endDate: LocalDateTime = LocalDateTime.now()
}

    enum class BookingStatus {
        ACTIVE,
        CANCELLED
    }