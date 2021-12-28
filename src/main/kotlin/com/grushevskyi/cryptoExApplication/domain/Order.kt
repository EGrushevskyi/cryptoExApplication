package com.grushevskyi.cryptoExApplication.domain

import lombok.NonNull
import javax.persistence.*

@Entity
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    var user: User? = null

    lateinit var currency: String

    var amount: Float = 0f

    var price: Float = 0f
}
