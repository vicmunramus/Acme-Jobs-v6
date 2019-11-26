
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `aguilar_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `company` varchar(255),
        `moment` datetime(6),
        `requirement` varchar(255),
        `salary` integer not null,
        `vacancy` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `announcement` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `more_info` varchar(255),
        `text` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `bronze_goal` varchar(255),
        `bronze_reward_amount` double precision,
        `bronze_reward_currency` varchar(255),
        `deadline` datetime(6),
        `description` varchar(255),
        `gold_goal` varchar(255),
        `gold_reward_amount` double precision,
        `gold_reward_currency` varchar(255),
        `silver_goal` varchar(255),
        `silver_reward_amount` double precision,
        `silver_reward_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `cobo_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `author` varchar(255),
        `creation_date` datetime(6),
        `description` varchar(255),
        `location` varchar(255),
        `salary` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `commercial` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `target` varchar(255),
        `card_holder` varchar(255),
        `credit_card_number` varchar(255),
        `cvv` varchar(255),
        `expiration_date` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `company_records` (
       `id` integer not null,
        `version` integer not null,
        `activity_desc` varchar(255),
        `ceo_name` varchar(255),
        `company_name` varchar(255),
        `contact_email` varchar(255),
        `contact_phone` varchar(255),
        `incorporated` bit,
        `rating` integer,
        `web_site` varchar(255),
        `work_sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `customisation_parameters` (
       `id` integer not null,
        `version` integer not null,
        `identifier` integer,
        `spam_list` varchar(255),
        `spam_threshold` float,
        primary key (`id`)
    ) engine=InnoDB;

    create table `doblado_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `degree` varchar(255),
        `location` varchar(255),
        `moment` datetime(6),
        `name` varchar(255),
        `text` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `investor_record` (
       `id` integer not null,
        `version` integer not null,
        `name` varchar(255),
        `sector` varchar(255),
        `stars` integer,
        `statement` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `munoz_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `group_name` varchar(255),
        `manager_name` varchar(255),
        `moment` datetime(6),
        `size` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `non_commercial` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `target` varchar(255),
        `jingle` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `offer` (
       `id` integer not null,
        `version` integer not null,
        `creation_moment` datetime(6),
        `deadline` datetime(6),
        `description` varchar(255),
        `max_reward_amount` double precision,
        `max_reward_currency` varchar(255),
        `min_reward_amount` double precision,
        `min_reward_currency` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `quintela_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `author` varchar(255),
        `created_at` datetime(6),
        `deadline_date` datetime(6),
        `priority` integer,
        `text` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `reina_bulletin` (
       `id` integer not null,
        `version` integer not null,
        `age` integer,
        `author` varchar(255),
        `create_date` datetime(6),
        `text` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request` (
       `id` integer not null,
        `version` integer not null,
        `created_at` datetime(6),
        `deadline` datetime(6),
        `description` varchar(255),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `worker` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `cualifications_record` varchar(255),
        `skills_record` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );
create index IDXnhikaa2dj3la6o2o7e9vo01y0 on `announcement` (`moment`);
create index IDXnr284tes3x8hnd3h716tmb3fr on `challenge` (`deadline`);
create index IDX6nd7baccjosrbgxx13s15d859 on `company_records` (`rating`);
create index IDXjaub8uhu1ab9se7oh9atwuktl on `customisation_parameters` (`identifier`);
create index IDXk2t3uthe649ao1jllcuks0gv4 on `investor_record` (`stars`);
create index IDXq2o9psuqfuqmq59f0sq57x9uf on `offer` (`deadline`);
create index IDXcp4664f36sgqsd0ihmirt0w0 on `offer` (`ticker`);

    alter table `offer` 
       add constraint UK_iex7e8fs0fh89yxpcnm1orjkm unique (`ticker`);
create index IDXlrvsw21ylkdqa1shrkwg1yssx on `request` (`deadline`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `worker` 
       add constraint FK_l5q1f33vs2drypmbdhpdgwfv3 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);
