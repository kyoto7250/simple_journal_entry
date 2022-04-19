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

    fun allAccountsByUserID(user_id: ID): List<AccountType> {
        return repository.findAllByUserID(user_id.toString().toLong()).map { AccountType(it) }
    }
}
