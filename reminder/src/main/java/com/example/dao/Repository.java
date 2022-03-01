package com.example.dao;

import java.sql.Connection;

public class Repository {

    Connection conn;

    public Repository() {
        this.conn = new CreateDB().getConn();
    }
}
