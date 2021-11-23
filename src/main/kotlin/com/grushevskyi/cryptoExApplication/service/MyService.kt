package com.grushevskyi.cryptoExApplication.service

import com.grushevskyi.cryptoExApplication.domain.Order
import com.grushevskyi.cryptoExApplication.domain.User
import com.grushevskyi.cryptoExApplication.domain.Wallet
import com.grushevskyi.cryptoExApplication.repositories.OrderRepository
import com.grushevskyi.cryptoExApplication.repositories.TradeRepository
import com.grushevskyi.cryptoExApplication.repositories.UserRepository
import com.grushevskyi.cryptoExApplication.repositories.WalletRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MyService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var walletRepository: WalletRepository

    @Autowired
    private lateinit var tradeRepository: TradeRepository

    @Autowired
    private lateinit var orderRepository: OrderRepository

    fun addUser(email: String) {
        val userOptional = userRepository?.findByName(email)

        if (userOptional != null && userOptional.isPresent) {
            throw RuntimeException("Such email is already registered")
        }
        userRepository?.save(User(email))
    }

    fun addWallet(user: User, currency: String) {
        val walletOptional = walletRepository.findByCurrency(currency)

        if (walletOptional != null && walletOptional.isPresent) {
            throw RuntimeException("Such wallet is already registered")
        }
        walletRepository.save(Wallet(user, currency, 0f))
    }

    fun updateWallet(wallet: Wallet, user: User, currency: String, amount: Float): Wallet {
        val wallet = walletRepository.findByCurrency(currency).get()
        wallet.balance += amount
        walletRepository.save(wallet)
        return wallet
    }

    fun performTrade(timestamp: Long, amount: Float, price: Float, currency: String) {
    }

    fun createOrder(order: Order) {
    }
}
