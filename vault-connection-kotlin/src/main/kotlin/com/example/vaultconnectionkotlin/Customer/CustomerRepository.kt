package com.example.vaultconnectionkotlin.Customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Int>{

    @Query("SELECT c FROM Customer c WHERE c.username= :username and c.password= :password")
    fun findCustomerByUsernameAndPassword(
            @Param("username") username: String?,
            @Param("password") password: String?
    ): Customer?

    @Query("SELECT c FROM Customer c WHERE c.username= :username")
    fun findCustomerByUsername(
            @Param("username") username: String?
    ): Customer?
}
