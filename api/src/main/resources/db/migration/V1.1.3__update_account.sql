use simple_journal_entry_db;

alter table accounts add column user_id bigint not null,
    add constraint user_id foreign key (user_id) references users(id) on delete cascade;
