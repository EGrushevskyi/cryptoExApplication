package com.grushevskyi.cryptoExApplication.repositories

import com.grushevskyi.cryptoExApplication.domain.User
import com.grushevskyi.cryptoExApplication.domain.Wallet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface WalletRepository : CrudRepository<Wallet, Long> {
    fun findByCurrency(currency: String?): Optional<Wallet>
}