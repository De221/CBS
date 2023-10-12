package com.example.CBS

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class CbsApplication

fun main(args: Array<String>) {
	runApplication<CbsApplication>(*args)
}
