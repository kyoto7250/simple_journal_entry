package com.okeicalm.simpleJournalEntry.usecase.user

import com.okeicalm.simpleJournalEntry.entity.User
import com.okeicalm.simpleJournalEntry.repository.UserRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class UserCreateUseCaseTests : DescribeSpec({
    lateinit var usecase: UserCreateUseCase
    val repository = mockk<UserRepository>()

    beforeEach {
        usecase = UserCreateUseCaseImpl(repository)
    }

    describe("call") {
        val input = UserCreateUseCaseInput("name")
        val user = User(name = "name")

        every { repository.create(user) } returns user.copy(id = 1)
        every { repository.findById(1) } returns user.copy(id = 1)

        it("returns new account") {
            val output = usecase.call(input)
            output.user.id.shouldBe(1)
            output.user.name.shouldBe("name")
        }
    }
})
