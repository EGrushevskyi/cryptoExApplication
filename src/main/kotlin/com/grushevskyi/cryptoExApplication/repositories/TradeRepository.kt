package com.grushevskyi.cryptoExApplication.repositories

import com.grushevskyi.cryptoExApplication.domain.Trade
import org.springframework.data.repository.CrudRepository

interface TradeRepository : CrudRepository<Trade, Long> {
}