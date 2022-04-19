package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.UserType
import com.okeicalm.simpleJournalEntry.usecase.user.UserDeleteUseCaseInput
import com.okeicalm.simpleJournalEntry.usecase.user.UserDeleteUseCase
import org.springframework.stereotype.Component

data class DeleteUserInput(val id: ID)

data class DeleteUserPayload(val deletedUser: UserType?)

@Component
class DeleteUserMutation(private val userDeletionUseCase: UserDeleteUseCase) : Mutation {
    fun deleteUser(input: DeleteUserInput): DeleteUserPayload {
        val output = userDeletionUseCase.call(UserDeleteUseCaseInput(id = input.id.toString().toLong()))

        val deleteUserType = if (output.user == null) {
            null
        } else {
            UserType(output.user)
        }

        return DeleteUserPayload(deleteUserType)
    }
}
