package com.grushevskyi.cryptoExApplication.domain

import lombok.NonNull
import javax.persistence.*

@Entity
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    private var user: User? = null

    @NonNull
    var currency: String? = null

    val amount: Float = 0f
}
