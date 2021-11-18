package com.grushevskyi.cryptoExApplication.domain

import lombok.Data
import lombok.NoArgsConstructor
import lombok.NonNull
import javax.persistence.Id

@Data
@NoArgsConstructor
class Trade {

    @Id
    var id: String? = null
    var timestamp: Long = 0
    var amount = 0f
    var price = 0f

    @NonNull
    var currency: String? = null

    fun performTrade(
        timestamp: Long,
        amount: Float,
        price: Float,
        currency: String?
    ) {
        this.currency = currency
        this.timestamp = timestamp
        this.amount = amount
        this.price = price
    }
}