create table Banner (
	bannerId LONG not null primary key,
	name VARCHAR(75) null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	link VARCHAR(75) null,
	image VARCHAR(75) null,
	position INTEGER,
	type_ INTEGER,
	status INTEGER,
	groupId LONG
);