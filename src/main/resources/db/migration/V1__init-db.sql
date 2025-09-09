CREATE TABLE IF NOT EXISTS sensors (
    id BIGSERIAL PRIMARY KEY,
    sensor_name TEXT NOT NULL,
    CONSTRAINT ck_sensor_name_length CHECK ( char_length(sensor_name) BETWEEN 3 AND 30 ),
    model TEXT NOT NULL,
    CONSTRAINT ck_model_length CHECK ( char_length(model) BETWEEN 3 AND 30 ),
    range_from INTEGER NOT NULL,
    range_to INTEGER NOT NULL,
    CONSTRAINT ck_range_length CHECK ( range_from < range_to ),
    type TEXT NOT NULL,
    unit TEXT NOT NULL,
    location VARCHAR(40),
    description VARCHAR(200)

);

CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE,
    password TEXT,
    roles TEXT
)