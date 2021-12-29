package com.grushevskyi.cryptoExApplication.domain

import lombok.NoArgsConstructor
import javax.persistence.*

//@NoArgsConstructor
@Entity
class User(var email: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @OneToMany(cascade = [CascadeType.ALL])
    private val wallets: Set<Wallet> = HashSet<Wallet>()

    @OneToMany(cascade = [CascadeType.ALL])
    private val orders: List<Order> = ArrayList<Order>()

    @OneToMany(cascade = [CascadeType.ALL])
    private val trades: List<Trade> = ArrayList<Trade>()

//    fun getId(): Long? {
//        return id
//    }
//
//    fun setId(id: Long?) {
//        this.id = id
//    }

}