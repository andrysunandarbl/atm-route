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
package com.project.core;

import org.apache.log4j.Logger;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.springframework.util.StopWatch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author andry on 10/04/16.
 */
public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    private double[][] distance;
    private Scanner scDistance;
    private static Scanner scLoc;
    private static List<Location> locationList = new ArrayList<Location>();

    //protected List<Location> locationList = new ArrayList<Location>();
    private static SimpleWeightedGraph<String, DefaultWeightedEdge> graph;

    // load location data
    static void loadLocationdata() throws FileNotFoundException {
        scLoc = new Scanner(new FileReader("/home/andry/Documents/atm/LocationCode.txt"));

        boolean firstFlag = false;
        logger.info("loading location code from tab file.......................");

        while (scLoc.hasNextLine()){
            // skip the header
            if(!firstFlag){
                scLoc.nextLine();
                firstFlag = true;
            }
            String[] locArr = scLoc.nextLine().split("\t");
            locationList.add(new Location(Integer.valueOf(locArr[0]), locArr[1]));
        }

        System.out.println("location list => "+locationList.toString());

    }

    /*
    private void generateGraphData(){
        StopWatch stopWatch = new StopWatch("Generate Graph from data");
        stopWatch.start("run the shortest path algorithm");
        // generate graph
        graph = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

        // create vertex
        for(int c=0; c< distance.length; c++){
            graph.addVertex(getLocationById(c).getName());
        }
        // set weight
        for(int x=0; x< distance.length; x++){
            for(int y=0; y< distance.length; y++){
                if(x!=y){
                    if(getLocationById(x)!=null && getLocationById(y)!=null){
                        DefaultWeightedEdge e = graph.addEdge(getLocationById(x).getName(), getLocationById(y).getName());
                        if(e!=null)
                            graph.setEdgeWeight(e,distance[x][y]);
                    }
                }

            }
        }

        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());
    }
    */

    public static double getWeightValue(String fromLoc, String toLoc){
        return graph.getEdgeWeight(graph.getEdge(fromLoc,toLoc));
    }

    public static String findRoute(String fromLoc, String toLoc) throws FileNotFoundException {

        if(graph!=null){
            List shortest_path = DijkstraShortestPath.findPathBetween(graph, fromLoc, toLoc);
            if(shortest_path!=null)
                return shortest_path.toString();
        }
        return "No Route Data";
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        loadLocationdata();
    }
}
