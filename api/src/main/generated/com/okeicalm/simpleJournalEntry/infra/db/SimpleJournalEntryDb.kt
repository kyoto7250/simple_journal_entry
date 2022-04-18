/*
 * This file is generated by jOOQ.
 */
package com.okeicalm.simpleJournalEntry.infra.db


import com.okeicalm.simpleJournalEntry.infra.db.tables.Accounts
import com.okeicalm.simpleJournalEntry.infra.db.tables.JournalEntries
import com.okeicalm.simpleJournalEntry.infra.db.tables.Journals
import com.okeicalm.simpleJournalEntry.infra.db.tables.Users

import kotlin.collections.List

import org.jooq.Catalog
import org.jooq.Table
import org.jooq.impl.SchemaImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class SimpleJournalEntryDb : SchemaImpl("simple_journal_entry_db", DefaultCatalog.DEFAULT_CATALOG) {
    public companion object {

        /**
         * The reference instance of <code>simple_journal_entry_db</code>
         */
        val SIMPLE_JOURNAL_ENTRY_DB: SimpleJournalEntryDb = SimpleJournalEntryDb()
    }

    /**
     * The table <code>simple_journal_entry_db.accounts</code>.
     */
    val ACCOUNTS: Accounts get() = Accounts.ACCOUNTS

    /**
     * The table <code>simple_journal_entry_db.journal_entries</code>.
     */
    val JOURNAL_ENTRIES: JournalEntries get() = JournalEntries.JOURNAL_ENTRIES

    /**
     * The table <code>simple_journal_entry_db.journals</code>.
     */
    val JOURNALS: Journals get() = Journals.JOURNALS

    /**
     * The table <code>simple_journal_entry_db.users</code>.
     */
    val USERS: Users get() = Users.USERS

    override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    override fun getTables(): List<Table<*>> = listOf(
        Accounts.ACCOUNTS,
        JournalEntries.JOURNAL_ENTRIES,
        Journals.JOURNALS,
        Users.USERS
    )
}