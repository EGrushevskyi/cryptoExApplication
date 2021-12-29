package com.grushevskyi.cryptoExApplication.repositories

import com.grushevskyi.cryptoExApplication.domain.Trade
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TradeRepository : CrudRepository<Trade, Long> {
}