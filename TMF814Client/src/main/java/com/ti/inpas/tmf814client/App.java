/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ti.inpas.tmf814client;

import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Alex
 */
@ComponentScan(basePackages = "com.ti")
@Configuration
@PropertySource("classpath:tmf814client.properties")
public class App {

    final static Logger logger
            = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("=================================================");
        logger.debug("Initializing internals...");
        AnnotationConfigApplicationContext ctx = null;
        try {
            ctx = new AnnotationConfigApplicationContext(App.class);
            App app = ctx.getBean(App.class);
            app.doStart();
        } // try
        finally {
            if (ctx != null) {
                ctx.close();
                logger.info("exit");
            } // if
        } // finally

    } // main

    private void doStart() {

        logger.info("Starting U2000eDC-1 version " + this.version);
        // do stuff

    }

    @Value("${version}")
    private String version;

} // App
