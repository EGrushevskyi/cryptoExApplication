package com.grushevskyi.cryptoExApplication.controller

import com.grushevskyi.cryptoExApplication.domain.Order
import com.grushevskyi.cryptoExApplication.domain.User
import com.grushevskyi.cryptoExApplication.domain.Wallet
import com.grushevskyi.cryptoExApplication.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RestController
@RequestMapping("/user")
class UserController (myService: MyService) {

    var myService: MyService? = null

    @PostMapping("/add")
    fun addUser(@RequestParam("email") email: String) {
        myService?.addUser(email)
    }

    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}