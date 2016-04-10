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
package com.project.atm.core;

/**
 * Author andry on 28/12/15.
 */
public class Coordinate {
    
    double latitude;
    double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
