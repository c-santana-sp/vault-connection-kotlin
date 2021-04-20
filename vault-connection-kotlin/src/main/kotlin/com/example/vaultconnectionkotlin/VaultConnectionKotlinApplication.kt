package com.example.vaultconnectionkotlin

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.vault.core.VaultTemplate
import org.springframework.vault.support.VaultResponse

@SpringBootApplication
@EnableConfigurationProperties(Credential::class)
class VaultConnectionKotlinApplication(
		@Autowired val credential: Credential
) : CommandLineRunner{

	companion object {
		private val logger = LoggerFactory.getLogger(VaultConnectionKotlinApplication::class.java);
	}

	override fun run(vararg args: String?) {
		println();
		logger.info("username: " + credential.username);
		logger.info("password: " + credential.password);
//
//		var response: VaultResponse = vaultTemplate.read("secret/data/vault-connection-kotlin")
//		println(response.data.toString())
	}

}
fun main(args: Array<String>) {
	runApplication<VaultConnectionKotlinApplication>(*args)
}
