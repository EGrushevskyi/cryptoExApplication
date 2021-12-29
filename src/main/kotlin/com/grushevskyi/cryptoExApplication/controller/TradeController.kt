package com.grushevskyi.cryptoExApplication.controller

import com.grushevskyi.cryptoExApplication.domain.Order
import com.grushevskyi.cryptoExApplication.domain.Trade
import com.grushevskyi.cryptoExApplication.domain.User
import com.grushevskyi.cryptoExApplication.repositories.TradeRepository
import com.grushevskyi.cryptoExApplication.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RestController
@RequestMapping("/trade")
class TradeController {

    @Autowired
    private lateinit var myService: MyService

    @Autowired
    private lateinit var tradeRepository: TradeRepository

    @GetMapping("/show_trades")
    fun showTrades(@RequestParam("user") user: User): List<Trade> {
        return tradeRepository.findAll().filter { it.user ==  user}
    }

    @PostMapping("/perform_trade")
    fun performTrade(@RequestParam("order") order: Order) {
        myService.performTrade(order)
    }
}