package com.example.vaultconnectionkotlin.Customer

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.vault.core.VaultTemplate
import org.springframework.vault.support.VaultResponse

@Service
class CustomerService(val customerRepository: CustomerRepository, val vaultTemplate: VaultTemplate) {

    fun save(customer: Customer) : ResponseEntity<Any> {
        if (customerRepository.findCustomerByUsername(customer.username) == null){
            customerRepository.save(customer)
            return ResponseEntity.status(200).build()
        } else {
            println("username already taken")
            return ResponseEntity.status(400).body("username already taken")
        }
    }

    fun checkUser(username: String, password: String): Customer? {
        return customerRepository.findCustomerByUsernameAndPassword(username, password)
    }

    fun login(username: String, password: String): Boolean?{
        val response: VaultResponse = vaultTemplate.read("secret/data/vault-connection-kotlin")
        val vaultMap = response.data?.get("data") as Map<*, *>

        val vaultUsername = vaultMap.get("vaultconnectionkotlin.username")
        val vaultPassword = vaultMap.get("vaultconnectionkotlin.password")

        if (vaultUsername == username && vaultPassword == password){
            return true
        }

        return false
    }
}