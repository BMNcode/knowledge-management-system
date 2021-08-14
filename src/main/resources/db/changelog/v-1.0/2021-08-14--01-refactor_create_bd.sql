create sequence id_sequence start 1000 increment 1;

create table branch (
	id                  int8            not null,
	created             timestamp,
	modified            timestamp,
	name                varchar(100),
	primary key (id)
);

create table branch_directories (
	branch_id           int8            not null,
	directories_id      int8            not null,
	directories_order   int4            not null,
	primary key (branch_id, directories_order)
);

create table content (
	id                  int8            not null,
	comment             varchar(2040),
	link                varchar(255),
	name                varchar(255),
	content_id          int8            not null,
	primary key (id)
);
create table directory (
	id                  int8            not null,
	created             timestamp,
	depth_level         int4,
	modified            timestamp,
	name                varchar(100),
	primary key (id)
);

alter table if exists branch
    add constraint UK_2qdmejoguc37exo9i2fjxb0qo
    unique (name);

alter table if exists branch_directories
    add constraint UK_f0aq7qwl5eoo7b7j4kdi59xkd
    unique (directories_id);

alter table if exists content
    add constraint UK_28y490fhk8snhqaegn43lenwr
    unique (link);

alter table if exists content
    add constraint UK_rjsbh4mgvigalpmpuitjf7b7e
    unique (name);

alter table if exists directory
    add constraint UniqueNameAndDepthLevel
    unique (name, depth_level);

alter table if exists branch_directories
    add constraint FKkvenj0cgoi1gana9kkuvmx1id
    foreign key (directories_id) references directory;

alter table if exists branch_directories
    add constraint FKhk5nuf8avjhji452qha3124bi
    foreign key (branch_id) references branch;

alter table if exists content
    add constraint FK2qhuu8e9c3ql68pchjerm1f8g
    foreign key (content_id) references directory;
