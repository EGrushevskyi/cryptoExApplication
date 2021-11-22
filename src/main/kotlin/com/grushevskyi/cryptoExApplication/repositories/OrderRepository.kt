package com.grushevskyi.cryptoExApplication.repositories

import com.grushevskyi.cryptoExApplication.domain.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long> {
}