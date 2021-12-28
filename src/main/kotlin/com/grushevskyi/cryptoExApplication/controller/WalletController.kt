package com.grushevskyi.cryptoExApplication.controller

import com.grushevskyi.cryptoExApplication.domain.User
import com.grushevskyi.cryptoExApplication.domain.Wallet
import com.grushevskyi.cryptoExApplication.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
@RestController
@RequestMapping("/wallet")
class WalletController(myService: MyService) {

    @Autowired
    private lateinit var myService: MyService

    @PostMapping("/add")
    fun addWallet(@RequestParam("user") user: User,
                  @RequestParam("currency") currency: String
    ) {
        myService.addWallet(user, currency)
    }

    @PostMapping("/update")
    fun updateWallet(@RequestParam("user") user: User,
                     @RequestParam("currency") currency: String,
                     @RequestParam("amount") amount: Float
    ) {
        myService.updateWallet(currency, amount)
    }
}