package com.grushevskyi.cryptoExApplication.controller

import com.grushevskyi.cryptoExApplication.domain.Order
import com.grushevskyi.cryptoExApplication.service.MyService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
@RestController
@RequestMapping("/orders")
class OrderController(myService: MyService) {

    var myService: MyService? = null

    @PostMapping("/createorder")
    fun createOrder(@RequestParam("order") order: Order) {
        myService?.createOrder(order)
    }
}