package com.grushevskyi.cryptoExApplication.domain

import javax.persistence.*

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    private var email: String? = null

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "user")
    private val wallets: Set<Wallet> = HashSet<Wallet>()

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }


}