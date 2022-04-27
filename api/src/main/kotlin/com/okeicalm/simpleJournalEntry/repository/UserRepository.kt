package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.User
import com.okeicalm.simpleJournalEntry.infra.db.tables.Users
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

interface UserRepository {
    fun findAll(): List<User>
    fun findById(id: Long): User?
    fun create(user: User): User
    fun update(user: User): User
    fun delete(id: Long): Long
}

@Repository
class UserRepositoryImpl(private val dslContext: DSLContext) : UserRepository {

    override fun findAll(): List<User> {
        return dslContext.select()
            .from(Users.USERS)
            .fetch()
            .into(User::class.java)
    }

    override fun findById(id: Long): User? {
        return dslContext
            .fetchOne(Users.USERS, Users.USERS.ID.eq(id))
            ?.into(User::class.java)
    }

    override fun create(user: User): User {
        val record = dslContext
            .newRecord(Users.USERS)
            .apply {
                name = user.name
            }
        record.store()

        return user.copy(id = record.id!!)
    }

    override fun update(user: User): User {
        dslContext
            .update(Users.USERS)
            .set(Users.USERS.ID, user.id)
            .set(Users.USERS.NAME, user.name)
            .where(Users.USERS.ID.eq(user.id))
            .execute()
        return user
    }

    override fun delete(id: Long): Long {
        dslContext
            .delete(Users.USERS)
            .where(Users.USERS.ID.eq(id))
            .execute()
        return id
    }
}
