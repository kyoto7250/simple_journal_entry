package com.okeicalm.simpleJournalEntry.usecase.user

import com.okeicalm.simpleJournalEntry.entity.User
import com.okeicalm.simpleJournalEntry.repository.UserRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class UserUpdateUseCaseTests : DescribeSpec({
    lateinit var usecase: UserUpdateUseCase
    val repository = mockk<UserRepository>()

    beforeEach {
        usecase = UserUpdateUseCaseImpl(repository)
    }

    describe("call") {
        val input = UserUpdateUseCaseInput(id=1, name="after")
        val user = User(id = 1, name = "after")

        every { repository.update(user) } returns user.copy(id=1)

        it("returns updated account") {
            val output = usecase.call(input)
            output.user.id.shouldBe(1)
            output.user.name.shouldBe("after")
        }
    }
})
