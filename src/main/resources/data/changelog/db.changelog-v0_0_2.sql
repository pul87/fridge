--liquibase formatted sql

--changeset pul:2
insert into Refrigerator (reference_id, version, created_by, created_at, name, location) values (
	'76bea618-4435-40c8-88b0-e016d9601c8d'
	,0
	,'pul'
	,now()
	,'frigo1'
	,'Erli');
insert into Refrigerator (reference_id, version, created_by, created_at, name, location) values (
	'76bea618-4435-40c8-88b0-e016d9601c8t'
	,0
	,'pul'
	,now()
	,'frigo2'
	,'Savona');