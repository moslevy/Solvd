package com.solvd.townhall.connectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyRunnable implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger(Thread.class);
    private ConnectionPool connectionPool;

    public MyRunnable(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        Connection connection = null;

        try {
            connection = connectionPool.getConnection();
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + "couldn't get a connection.");
            LOGGER.error("Thread " + name + " couldn't get a connection.");
        }
        System.out.println("Thread " + name + " got the connection " + connection.getConnectionNumber());
        LOGGER.info("Thread " + name + " got the connection " + connection.getConnectionNumber());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " can't sleep.");
            LOGGER.error("Thread " + name + " can't sleep.");
        }
        connectionPool.returnConnection(connection);
        System.out.println("Thread " + name + " returned the connection " + connection.getConnectionNumber() + " to the connection pool and finished.");
        LOGGER.info("Thread " + name + " returned the connection " + connection.getConnectionNumber() + " to the connection pool and finished.");
    }
}
