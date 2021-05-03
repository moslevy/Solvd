package com.solvd.townhalldb.connectionPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ConnectionPool {

    private final int maxSize;
    private static ConnectionPool singleInstance = null;
    private int connectionsCount;
    private BlockingQueue<Connection> connections; //thread safe queue

    private ConnectionPool(Integer maxSize){
        this.maxSize = maxSize;
        connectionsCount = 0;
        connections = new PriorityBlockingQueue<>();
    }

    public static ConnectionPool ConnectionPool(int maxSize){
        if(singleInstance == null){
            singleInstance = new ConnectionPool(maxSize);
        }
        return singleInstance;
    }


    public static ConnectionPool getInstance(){
        if(singleInstance == null){
            singleInstance = new ConnectionPool(3);
        }
        return singleInstance;
    }



    public Connection getConnection() throws InterruptedException {
        synchronized (this){ //because of shared fields
            if (connections.size() == 0 && connectionsCount < maxSize){ //there's no available conn and don't pass the max
                //create a new connection
                connections.add(new Connection(connectionsCount));
                connectionsCount++;
            }
        }
        return connections.take(); //Retrieves and removes the head of this queue, waiting if necessary until an element becomes available.
    }

    public void returnConnection(Connection connection){
        connections.add(connection);
    }

    public void close(){
        //close all connections
        connections = new PriorityBlockingQueue<Connection>();
        connectionsCount = 0;
    }

}
