package com.grushevskyi.cryptoExApplication.domain

import lombok.NoArgsConstructor
import javax.persistence.*


@Entity
class Wallet (user: User, currency: String, balance: Float) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @ManyToOne
    private var user: User? = null



}