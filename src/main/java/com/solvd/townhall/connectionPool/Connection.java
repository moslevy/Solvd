package com.solvd.townhall.connectionPool;

public class Connection implements Comparable<Connection>{

    private int connectionNumber;

    public Connection(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    public Integer getConnectionNumber() {
        return connectionNumber;
    }


    @Override
    public int compareTo(Connection o) {
        return this.getConnectionNumber().compareTo(o.getConnectionNumber());
    }
}
