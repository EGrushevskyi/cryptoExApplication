package com.grushevskyi.cryptoExApplication.controller

import com.grushevskyi.cryptoExApplication.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Controller
@RestController
@RequestMapping("/user")
class UserController(myService: MyService) {

    @Autowired
    private lateinit var myService: MyService

    @PostMapping("/add")
    fun addUser(@RequestParam("email") email: String) {
        myService?.addUser(email)
    }

    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}
