package com.okeicalm.simpleJournalEntry.usecase.user

import com.okeicalm.simpleJournalEntry.entity.User
import com.okeicalm.simpleJournalEntry.repository.UserRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class UserDeleteUseCaseTests : DescribeSpec({
    lateinit var usecase: UserDeleteUseCase
    val repository = mockk<UserRepository>()

    beforeEach {
        usecase = UserDeleteUseCaseImpl(repository)
    }

    describe("call") {
        val input = UserDeleteUseCaseInput(id=1)
        val user = User(id = 1, name = "name")


        describe("if user exist") {
            every { repository.findById(user.id) } returns user.copy(id = 1)
            every { repository.delete(user.id) } returns user.id

            it("returns deleted account") {
                val output = usecase.call(input)
                output.user?.id.shouldBe(1)
            }
        }

        describe("if user not exist") {
            every { repository.findById(user.id) } returns null

            it("returns null") {
                val output = usecase.call(input)
                output.user?.id.shouldBe(null)
            }
        }
    }
})
