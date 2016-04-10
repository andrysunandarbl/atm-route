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
public class Location {
    
    int id;
    String name;
    Coordinate coordinate;

    public Location() {
    }

    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Location(int id, String name, Coordinate coordinate) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ",code='" + name + '\'' +
                //", coordinate=" + coordinate +
                '}';
    }
}
