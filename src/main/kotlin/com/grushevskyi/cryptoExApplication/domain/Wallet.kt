package com.grushevskyi.cryptoExApplication.domain

import javax.persistence.*

@Entity
class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @ManyToOne
    private val user: User? = null

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }


}