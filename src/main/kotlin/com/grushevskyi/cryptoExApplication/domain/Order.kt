package com.grushevskyi.cryptoExApplication.domain

import javax.persistence.ManyToOne

data class Order(
    val id: Long,
    var user: User,
    val currency: String,
    val amount: Float
) {

    fun createOrder(
        price: Float,
        currency: String
    ): Order {
        return Order(id = id, user = user, currency = currency, amount = amount)
    }

}