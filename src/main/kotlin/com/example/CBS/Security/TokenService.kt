package com.example.CBS.Security

import com.example.CBS.Entities.Customer
import com.example.CBS.Services.CustomerService
import org.springframework.security.oauth2.jwt.*
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@Service
class TokenService(
        private val jwtDecoder: JwtDecoder,
        private val jwtEncoder: JwtEncoder,
        private val userService: CustomerService,
) {
    fun createToken(customer: Customer): String {
        val jwsHeader = JwsHeader.with { "HS256" }.build()
        val claims = JwtClaimsSet.builder()
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(30L, ChronoUnit.DAYS))
                .subject(customer.email)
                .claim("userId", customer.id)
                .build()
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).tokenValue
    }

    fun parseToken(token: String): Optional<Customer> {
        return try {
            val jwt = jwtDecoder.decode(token)
            val userId = jwt.claims["userId"] as UUID
            userService.findById(userId)
        } catch (e: Exception) {
            Optional.of(Customer("example","example","example"))
        }
    }
}