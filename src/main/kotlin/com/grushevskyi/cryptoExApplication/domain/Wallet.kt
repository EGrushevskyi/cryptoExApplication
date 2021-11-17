package com.grushevskyi.cryptoExApplication.domain

data class Wallet(
    val id: Long,
    var user: User,
    val currency: String,
    var balance: Float
) {
    fun performTrade(amount: Float): Wallet {
        return Wallet(id = id, user = user, currency = currency, balance = balance + amount)
    }

    fun create(user: User, currency: String): Wallet {
        return Wallet(id = id, user = user, currency = currency, balance = 0f)
    }
}