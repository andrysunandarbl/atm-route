/**
 * Innovez-One, Proprietary Software Cloud Communications
 *  Copyright (c) 2015, Innovez-One and individual contributors
 *  by the @authors tag.
 *
 *  This program is Proprietary Software: you can not redistribute it and/or modify
 *  without license from Innovez-One.
 *
 *  Website : http://www.innovez-one.com/
 *  Report bugs to <techsupport@innovez-one.com>.
 *  Copyright (C) 2015 PT. Innovez-One. All rights reserved.
 */
package com.project.atm.http.util;

import com.project.atm.common.util.ResourceHelper;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Author andry on 21/01/16.
 */
public class HttpExecutor implements ApplicationListener<ContextClosedEvent> {
    private static final Logger logger = Logger.getLogger(HttpExecutor.class);

    private ThreadPoolTaskExecutor taskExecutor;

    public HttpExecutor(ThreadPoolTaskExecutor taskExecutor){
        this.taskExecutor = taskExecutor;

        String httpThread = ResourceHelper.getAppResource("httpThread");
        if (httpThread.isEmpty() || httpThread.equals("")) {
            taskExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors()/2);
        } else {
            try {
                taskExecutor.setCorePoolSize(Integer.parseInt(httpThread));
            } catch (NumberFormatException nfe) {
                logger.error(nfe.getMessage() + ", set to default configuration");
                taskExecutor.setCorePoolSize(Runtime.getRuntime().availableProcessors()/2);
            }
        }
    }

    public void execute(Runnable task){
        taskExecutor.execute(task);
    }

    public ThreadPoolTaskExecutor getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        logger.info("http executor shutdown");
        taskExecutor.shutdown();
    }
}
