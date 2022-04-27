package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.AccountType
import com.okeicalm.simpleJournalEntry.usecase.account.AccountCreateUseCaseInput
import com.okeicalm.simpleJournalEntry.usecase.account.AccountCreateUseCase
import org.springframework.stereotype.Component

data class CreateAccountInput(val code: String, val name: String, val elementType: Int, val userId: ID)

@Component
class CreateAccountMutation(private val accountCreateUseCase: AccountCreateUseCase) : Mutation {
    fun createAccount(input: CreateAccountInput): AccountType {
        val output = accountCreateUseCase.call(
            AccountCreateUseCaseInput(
                code = input.code,
                name = input.name,
                elementType = input.elementType,
                userId = input.userId.toString().toLong()
            )
        )
        return AccountType(output.account)
    }
}
