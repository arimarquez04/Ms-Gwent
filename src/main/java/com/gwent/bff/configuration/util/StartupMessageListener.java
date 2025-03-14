package com.gwent.bff.configuration.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class StartupMessageListener implements ApplicationListener<ApplicationReadyEvent> {
    Logger logger = Logger.getLogger(StartupMessageListener.class.getName());
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        logger.info("\n\n¡La aplicación de Spring se ha iniciado con éxito!\n\n");
    }
}