package com.grushevskyi.cryptoExApplication.controller

import com.grushevskyi.cryptoExApplication.domain.Order
import com.grushevskyi.cryptoExApplication.domain.User
import com.grushevskyi.cryptoExApplication.domain.Wallet
import com.grushevskyi.cryptoExApplication.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RestController
@RequestMapping("/user")
class UserController (myService: MyService) {

    @Autowired
    private lateinit var myService: MyService

    @PostMapping("/add")
    fun addUser(@RequestParam("email") email: String): ResponseEntity<Any> {
        myService.addUser(email)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}