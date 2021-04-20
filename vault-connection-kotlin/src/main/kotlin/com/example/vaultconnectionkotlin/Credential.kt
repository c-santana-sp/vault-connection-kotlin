package com.example.vaultconnectionkotlin

import lombok.Data
import org.springframework.boot.context.properties.ConfigurationProperties

//@Data
@ConfigurationProperties("vaultconnectionkotlin")
class Credential(var username: String? = null, var password: String? = null){

}