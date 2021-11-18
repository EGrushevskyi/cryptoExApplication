package com.grushevskyi.cryptoExApplication.domain

import javax.persistence.ManyToOne

data class Wallet(
    val id: Long,
    var user: User,
    val currency: String,
    var balance: Float
) {


    fun updateWallet(amount: Float): Wallet {
        return Wallet(id = id, user = user, currency = currency, balance = balance + amount)
    }

    fun createWallet(user: User, currency: String): Wallet {
        return Wallet(id = id, user = user, currency = currency, balance = 0f)
    }
}