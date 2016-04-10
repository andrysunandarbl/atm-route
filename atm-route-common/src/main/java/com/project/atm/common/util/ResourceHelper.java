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
package com.project.atm.common.util;

import org.apache.log4j.Logger;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Author andry on 28/12/15.
 */
public final class ResourceHelper {

    private ResourceHelper() {
    }

    private static final Logger logger = Logger.getLogger(ResourceHelper.class);

    private static final String APPLICATION = "application";
    private static final String SERVER = "server";

    public static String getAppResource(String key) {
        String keyValue = "";
        try {
            keyValue = ResourceBundle.getBundle(APPLICATION).getString(key).trim();
        } catch (MissingResourceException ex) {
            logger.debug("Key "+key+" is not found or properties file not found");
            keyValue = "";
        } catch (Exception ex) {
            logger.debug("Exception :" + ex.getMessage());
            keyValue = "";
        }

        return keyValue;
    }

    public static String getServerResource(String key) {
        String keyValue = "";
        try {
            keyValue = ResourceBundle.getBundle(SERVER).getString(key).trim();
        } catch (MissingResourceException ex) {
            logger.debug("Key "+key+" is not found or properties file not found");
            keyValue = "";
        } catch (Exception ex) {
            logger.debug("Exception :" + ex.getMessage());
            keyValue = "";
        }

        return keyValue;
    }
}
