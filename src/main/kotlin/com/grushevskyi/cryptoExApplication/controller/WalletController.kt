package com.grushevskyi.cryptoExApplication.controller

import com.grushevskyi.cryptoExApplication.domain.Order
import com.grushevskyi.cryptoExApplication.domain.User
import com.grushevskyi.cryptoExApplication.domain.Wallet
import com.grushevskyi.cryptoExApplication.repositories.WalletRepository
import com.grushevskyi.cryptoExApplication.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RestController
@RequestMapping("/wallet")
class WalletController(myService: MyService) {

    @Autowired
    private lateinit var myService: MyService

    @Autowired
    private lateinit var walletRepository: WalletRepository

    @PostMapping("/add")
    fun addWallet(@RequestParam("user") user: User,
                  @RequestParam("currency") currency: String
    ) {
        myService.addWallet(user, currency)
    }

    @GetMapping("/show_wallets")
    fun showWallets(@RequestParam("user") user: User): List<Wallet> {
        return walletRepository.findAll().filter { it.user ==  user}
    }

    // This endpoint is not necessary, to be removed
    @PostMapping("/update")
    fun updateWallet(@RequestParam("user") user: User,
                     @RequestParam("currency") currency: String,
                     @RequestParam("amount") amount: Float
    ) {
        myService.updateWallet(currency, amount)
    }
}