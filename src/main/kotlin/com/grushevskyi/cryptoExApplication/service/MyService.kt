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

    private var userRepository: UserRepository? = null
    private var walletRepository: WalletRepository? = null
    private var tradeRepository: TradeRepository? = null
    private var orderRepository: OrderRepository? = null

    @Autowired
    fun MyService(userRepository: UserRepository?, walletRepository: WalletRepository?) {
        this.userRepository = userRepository
        this.walletRepository = walletRepository
        this.tradeRepository = tradeRepository
        this.orderRepository = orderRepository
    }

    fun addUser(email: String) {
        val userOptional = userRepository?.findByName(email)

        if (userOptional != null && userOptional.isPresent) {
                throw RuntimeException("Such email is already registered")
        }
        userRepository?.save(User(email))
    }

    fun addWallet(user: User, currency: String) {
        val walletOptional = walletRepository?.findByCurrency(currency)

        if (walletOptional != null && walletOptional.isPresent) {
            throw RuntimeException("Such wallet is already registered")
        }
        walletRepository?.save(Wallet(user, currency, 0f))
    }

    fun updateWallet(wallet: Wallet, user: User, currency: String, amount: Float): Wallet {


        val walletOptional = walletRepository?.findByCurrency(currency)
        var wallet = walletOptional?.get()

        // не понятно как тут достать кошелек из репы, апдейтнуть (добавить amount к balance) и сохранить обратно

        return Wallet(user = user, currency = currency, balance = amount)

    }

    fun performTrade(timestamp: Long, amount: Float, price: Float, currency: String) {

    }

    fun createOrder(order: Order) {

    }

}