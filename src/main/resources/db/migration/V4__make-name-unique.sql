alter table sensors
add constraint
ck_name_unique UNIQUE (sensor_name);