package com.grushevskyi.cryptoExApplication.domain

import lombok.NoArgsConstructor
import javax.persistence.*

@NoArgsConstructor
@Entity
class User(email: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "wallet")
    private val wallets: Set<Wallet> = HashSet<Wallet>()

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "order")
    private val orders: List<Order> = ArrayList<Order>()

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "trade")
    private val trades: List<Trade> = ArrayList<Trade>()

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

}