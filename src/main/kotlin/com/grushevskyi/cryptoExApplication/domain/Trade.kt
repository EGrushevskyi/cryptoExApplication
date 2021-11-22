package com.grushevskyi.cryptoExApplication.domain

import lombok.Data
import lombok.NoArgsConstructor
import lombok.NonNull
import javax.persistence.*

@Entity
@NoArgsConstructor
class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    val user: User? = null

    var timestamp: Long = 0
    var amount = 0f
    var price = 0f

    @NonNull
    var currency: String? = null

}