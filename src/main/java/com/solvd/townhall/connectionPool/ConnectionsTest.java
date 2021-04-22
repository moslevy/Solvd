package com.solvd.townhall.connectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionsTest {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionsTest.class);
    private static final int THREADS_NUM = 6;

    public static void main (String[] args){

        ConnectionPool connectionPool = ConnectionPool.ConnectionPool(5);

        //With Runnable

        MyRunnable runnable = new MyRunnable(connectionPool);

        for(int i=0; i<THREADS_NUM; i++){
            new Thread(runnable, String.valueOf(i)).start();
        }


        //With Executor Service and Completable Future

        ExecutorService executor = Executors.newFixedThreadPool(6);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Completable future 1", executor);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Completable future 2", executor);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Completable future 3", executor);

        try {
            LOGGER.info(future1.get());
            LOGGER.info(future2.get());
            LOGGER.info(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error("Couldn't get the information from some completable future.");
        }

        executor.shutdown();


    }
}
