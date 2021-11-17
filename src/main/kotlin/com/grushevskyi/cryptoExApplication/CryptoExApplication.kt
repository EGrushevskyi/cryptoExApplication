package com.grushevskyi.cryptoExApplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CryptoExApplication

fun main(args: Array<String>) {
	runApplication<CryptoExApplication>(*args)
}
