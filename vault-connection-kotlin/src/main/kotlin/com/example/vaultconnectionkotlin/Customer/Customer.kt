package com.example.vaultconnectionkotlin.Customer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Customer(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
        @NotBlank val username: String,
        @NotBlank val password: String){
}
