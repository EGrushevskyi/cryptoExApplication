package com.grushevskyi.cryptoExApplication.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.commons.validator.routines.EmailValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private var objectMapper = ObjectMapper()

    @Test
    fun testUsingEmailValidator() {
        val email = "azaza"
        assertFalse(
            EmailValidator.getInstance()
                .isValid(email)
        )
    }

    @Test
    fun canAddUser() {
        val email = "test_email@gmail.com"

        val request: RequestBuilder = MockMvcRequestBuilders
            .post("/user/add?email=${email}")
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(email))
            .contentType(MediaType.APPLICATION_JSON)

        mockMvc.perform(request)
            .andExpect(status().isOk)
            .andReturn()
    }
}