CREATE TABLE books (
                      id UUID PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      creation_date TIMESTAMP WITH TIME ZONE NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      content TEXT NOT NULL
);