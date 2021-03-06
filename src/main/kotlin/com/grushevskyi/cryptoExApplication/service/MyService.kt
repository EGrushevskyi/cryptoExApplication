package com.grushevskyi.cryptoExApplication.service

import com.grushevskyi.cryptoExApplication.domain.Order
import com.grushevskyi.cryptoExApplication.domain.Trade
import com.grushevskyi.cryptoExApplication.domain.User
import com.grushevskyi.cryptoExApplication.domain.Wallet
import com.grushevskyi.cryptoExApplication.repositories.OrderRepository
import com.grushevskyi.cryptoExApplication.repositories.TradeRepository
import com.grushevskyi.cryptoExApplication.repositories.UserRepository
import com.grushevskyi.cryptoExApplication.repositories.WalletRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime


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
        val userOptional = userRepository.findByEmail(email)

        if (userOptional.isPresent) {
            throw RuntimeException("Such email is already registered")
        }
        userRepository.save(User(email))
    }

    fun addWallet(user: User, currency: String) {
        val walletOptional = walletRepository.findByCurrency(currency)

        if (walletOptional.isPresent) {
            throw RuntimeException("Such wallet is already registered")
        }
        walletRepository.save(Wallet(user, currency, 0f))
    }

    fun updateWallet(currency: String, amount: Float) {
        val wallet = walletRepository.findByCurrency(currency).get()
        wallet.balance += amount
        walletRepository.save(wallet)
    }

    fun performTrade(order: Order) {
        val timestamp = System.currentTimeMillis()
        val currency = order.currency
        val amount = order.amount
        val trade = Trade(timestamp, order)

        updateWallet(currency, amount)
        tradeRepository.save(trade)
    }


    fun createOrder(order: Order) {
        orderRepository.save(Order())
    }

    fun cancelOrder(order: Order) {
        val orderToCancel = order.id?.let { orderRepository.findById(it) }?.get()
        if (orderToCancel != null) {
            orderRepository.delete(orderToCancel)
        }
    }
}

