package com.grushevskyi.cryptoExApplication.repositories

import com.grushevskyi.cryptoExApplication.domain.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : CrudRepository<Order, Long> {
}