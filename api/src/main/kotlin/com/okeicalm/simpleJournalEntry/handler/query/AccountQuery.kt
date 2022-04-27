package com.okeicalm.simpleJournalEntry.handler.query
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.type.AccountType
import com.okeicalm.simpleJournalEntry.repository.AccountRepository
import org.springframework.stereotype.Component

@Component
class AccountQuery(private val repository: AccountRepository) : Query {
    fun allAccounts(): List<AccountType> {
        return repository.findAll().map { AccountType(it) }
    }

    fun accountsByUserID(userId: ID): List<AccountType> {
        return repository.findByUserID(userId.toString().toLong()).map { AccountType(it) }
    }
}
