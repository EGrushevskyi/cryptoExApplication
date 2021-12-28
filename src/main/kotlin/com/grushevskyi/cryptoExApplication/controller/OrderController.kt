package com.grushevskyi.cryptoExApplication.controller

import com.grushevskyi.cryptoExApplication.domain.Order
import com.grushevskyi.cryptoExApplication.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
@RestController
@RequestMapping("/orders")
class OrderController(myService: MyService) {

    @Autowired
    private lateinit var myService: MyService

    @PostMapping("/create_order")
    fun createOrder(@RequestParam("order") order: Order) {
        myService.createOrder(order)
    }

    @PostMapping("/cancel_order")
    fun cancelOrder(@RequestParam("order") order: Order) {
        myService.cancelOrder(order)
    }
}