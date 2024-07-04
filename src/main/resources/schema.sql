--Embedded memory DBs like H2 DB run schema.sql automatically
CREATE TABLE IF NOT EXISTS run(
    id INT NOT NULL,
    title VARCHAR(250) NOT NULL,
    start TIMESTAMP NOT NULL,
    finish TIMESTAMP NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(10),
    version INT,
    PRIMARY KEY(id)
);