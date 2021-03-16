package com.example.hw1.helloworld;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        System.out.println("Hello World!");
        logger.trace("[TRACE] We've just greeted the user!");
        logger.debug("[DEBUG] We've just greeted the user!");
        logger.info("[INFO] We've just greeted the user!");
        logger.warn("[WARN] We've just greeted the user!");
        logger.error("[ERROR] We've just greeted the user!");
        logger.fatal("[FATAL] We've just greeted the user!");
    }
}
