package jII_collections_practice.service;

import jII_collections_practice.model.Driver;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Auxiliary utility methods
 *
 * @author Danny Briskin (sql.coach.kiev@gmail.com)
 * on  27.07.2017 for jII_collections_practice project.
 */
public class Util {
    /**
     * Auxiliary method to print queue in a right order. Using a copy of queue
     * to poll
     *
     * @param queue - a PriorityQueue to print
     */
    public static void printPriorityQueue(Queue<Driver> queue, Comparator<Driver> comparator) {
        Queue<Driver> temp = new PriorityQueue<>(comparator);
        temp.addAll(queue);

        System.out.println("--------------- Queue in order ---------------------");
        while (!temp.isEmpty())
            System.out.println(temp.poll());
        System.out.println("--------------- end of Queue---------------------");
    }
}
