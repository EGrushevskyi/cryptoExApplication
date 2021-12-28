package com.grushevskyi.cryptoExApplication.controller

import com.grushevskyi.cryptoExApplication.domain.Order
import com.grushevskyi.cryptoExApplication.domain.User
import com.grushevskyi.cryptoExApplication.repositories.OrderRepository
import com.grushevskyi.cryptoExApplication.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RestController
@RequestMapping("/orders")
class OrderController(myService: MyService) {

    @Autowired
    private lateinit var myService: MyService

    @Autowired
    private lateinit var orderRepository: OrderRepository

    @PostMapping("/create_order")
    fun createOrder(@RequestParam("order") order: Order) {
        myService.createOrder(order)
    }

    @PostMapping("/cancel_order")
    fun cancelOrder(@RequestParam("order") order: Order) {
        myService.cancelOrder(order)
    }

    @GetMapping("/show_orders")
    fun showOrders(@RequestParam("user") user: User): List<Order> {
        return orderRepository.findAll().filter { it.user ==  user}
    }
}