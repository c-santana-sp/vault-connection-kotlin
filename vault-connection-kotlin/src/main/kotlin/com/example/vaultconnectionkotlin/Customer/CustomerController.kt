package com.example.vaultconnectionkotlin.Customer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.vault.core.VaultTemplate
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/customers")
class CustomerController(val customerService: CustomerService, @Autowired val vaultTemplate: VaultTemplate) {

    @PostMapping("/add")
    fun add(@RequestBody @Valid customer: Customer) : ResponseEntity<Any> {
        customerService.save(customer)
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/vault")
    fun login(@RequestBody @Valid customer: Customer): ResponseEntity<Any>{
        val res = customerService.login(customer.username, customer.password)

        return if (res == true) {
            ResponseEntity.status(200).body("username and password matched")
        } else {
            ResponseEntity.status(204).build()
        }
    }

    @PostMapping("/check")
    fun checkUser(@RequestBody @Valid customer: Customer): ResponseEntity<Any> {

        val c = customerService.checkUser(customer.username, customer.password)
        return if (c == null) ResponseEntity.status(204).build() else ResponseEntity.status(200).body(c);
    }
}