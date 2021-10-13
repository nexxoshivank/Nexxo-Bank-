# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

-- init script create procs
-- Inital script to create stored procedures etc for mysql platform
DROP PROCEDURE IF EXISTS usp_ebean_drop_foreign_keys;

delimiter $$
--
-- PROCEDURE: usp_ebean_drop_foreign_keys TABLE, COLUMN
-- deletes all constraints and foreign keys referring to TABLE.COLUMN
--
CREATE PROCEDURE usp_ebean_drop_foreign_keys(IN p_table_name VARCHAR(255), IN p_column_name VARCHAR(255))
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE c_fk_name CHAR(255);
  DECLARE curs CURSOR FOR SELECT CONSTRAINT_NAME from information_schema.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE() and TABLE_NAME = p_table_name and COLUMN_NAME = p_column_name
      AND REFERENCED_TABLE_NAME IS NOT NULL;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  OPEN curs;

  read_loop: LOOP
    FETCH curs INTO c_fk_name;
    IF done THEN
      LEAVE read_loop;
    END IF;
    SET @sql = CONCAT('ALTER TABLE ', p_table_name, ' DROP FOREIGN KEY ', c_fk_name);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
  END LOOP;

  CLOSE curs;
END
$$

DROP PROCEDURE IF EXISTS usp_ebean_drop_column;

delimiter $$
--
-- PROCEDURE: usp_ebean_drop_column TABLE, COLUMN
-- deletes the column and ensures that all indices and constraints are dropped first
--
CREATE PROCEDURE usp_ebean_drop_column(IN p_table_name VARCHAR(255), IN p_column_name VARCHAR(255))
BEGIN
  CALL usp_ebean_drop_foreign_keys(p_table_name, p_column_name);
  SET @sql = CONCAT('ALTER TABLE ', p_table_name, ' DROP COLUMN ', p_column_name);
  PREPARE stmt FROM @sql;
  EXECUTE stmt;
END
$$
create table users (
  user_id                       integer auto_increment not null,
  date_of_birth                 datetime(6),
  mobile                        varchar(255),
  email                         varchar(255),
  aadhaar_number                varchar(255),
  pan_no                        varchar(255),
  created_on                    datetime(6),
  status_id                     integer,
  role_id                       integer,
  first_name                    varchar(255),
  last_name                     varchar(255),
  constraint pk_users primary key (user_id)
);

create table feedback (
  feedback_id                   integer auto_increment not null,
  feedback                      varchar(255),
  created_on                    datetime(6),
  user_id                       integer,
  constraint pk_feedback primary key (feedback_id)
);

create table roles (
  role_id                       integer auto_increment not null,
  role_status                   varchar(255),
  constraint pk_roles primary key (role_id)
);

create table statuses (
  status_id                     integer auto_increment not null,
  status_name                   varchar(255),
  constraint pk_statuses primary key (status_id)
);

create table transaction_history (
  transaction_id                integer auto_increment not null,
  user_id_transaction_table     integer,
  amount                        integer,
  date_time                     datetime(6),
  ifsc                          varchar(255),
  merchant_account_number       integer,
  t_id                          integer,
  constraint pk_transaction_history primary key (transaction_id)
);

create table transaction_type (
  trans_id                      integer auto_increment not null,
  trans_type                    varchar(255),
  constraint pk_transaction_type primary key (trans_id)
);

create table user_passwords (
  id                            integer,
  pass                          varchar(255),
  created_on                    datetime(6)
);

create index ix_users_status_id on users (status_id);
alter table users add constraint fk_users_status_id foreign key (status_id) references statuses (status_id) on delete restrict on update restrict;

create index ix_users_role_id on users (role_id);
alter table users add constraint fk_users_role_id foreign key (role_id) references roles (role_id) on delete restrict on update restrict;

create index ix_transaction_history_user_id_transaction_table on transaction_history (user_id_transaction_table);
alter table transaction_history add constraint fk_transaction_history_user_id_transaction_table foreign key (user_id_transaction_table) references users (user_id) on delete restrict on update restrict;

create index ix_transaction_history_t_id on transaction_history (t_id);
alter table transaction_history add constraint fk_transaction_history_t_id foreign key (t_id) references transaction_type (trans_id) on delete restrict on update restrict;

create index ix_user_passwords_id on user_passwords (id);
alter table user_passwords add constraint fk_user_passwords_id foreign key (id) references users (user_id) on delete restrict on update restrict;


# --- !Downs

alter table users drop foreign key fk_users_status_id;
drop index ix_users_status_id on users;

alter table users drop foreign key fk_users_role_id;
drop index ix_users_role_id on users;

alter table transaction_history drop foreign key fk_transaction_history_user_id_transaction_table;
drop index ix_transaction_history_user_id_transaction_table on transaction_history;

alter table transaction_history drop foreign key fk_transaction_history_t_id;
drop index ix_transaction_history_t_id on transaction_history;

alter table user_passwords drop foreign key fk_user_passwords_id;
drop index ix_user_passwords_id on user_passwords;

drop table if exists users;

drop table if exists feedback;

drop table if exists roles;

drop table if exists statuses;

drop table if exists transaction_history;

drop table if exists transaction_type;

drop table if exists user_passwords;

