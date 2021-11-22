package com.grushevskyi.cryptoExApplication.repositories

import com.grushevskyi.cryptoExApplication.domain.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, Long> {
    fun findByName(email: String?): Optional<User>
}