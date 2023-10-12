package com.example.CBS.Controllers

import com.auth0.jwt.JWTCreator
import com.example.CBS.DTOs.LoginDTO
import com.example.CBS.DTOs.Message
import com.example.CBS.DTOs.RegisterDTO
import com.example.CBS.Entities.Customer
import com.example.CBS.Security.TokenService
import com.example.CBS.Services.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")
class AuthController(private val customerService: CustomerService,  private val tokenService: TokenService) {
    @GetMapping("hello")
    fun hello(): String {
        return "hello"
    }

    @PostMapping("register")
    fun register(@RequestBody dto: RegisterDTO): ResponseEntity<Any> {
        if(customerService.findByEmail(dto.email) != null)
        {return ResponseEntity.badRequest().body(Message("An account with this email already exists."))}
        val customer = Customer(dto.fullName, dto.email, dto.password)
        customer.SetPassword(dto.password) //TODO NOT A GOOD WAY TO DO IT
        customerService.save(customer)
        val token = tokenService.createToken(customer)
        return ResponseEntity.ok(token)
    }

    @PostMapping("login")
    fun login(@RequestBody dto: LoginDTO): ResponseEntity<Any>{
        val customer = this.customerService.findByEmail(dto.email)
                ?: return ResponseEntity.badRequest().body(Message("Customer not found!"))
        if(!customer.comparePassword(dto.password))
        {
            return ResponseEntity.badRequest().body(Message("Invalid password!"))
        }

        val token = tokenService.createToken(customer);

        return ResponseEntity.ok(token)
    }
}