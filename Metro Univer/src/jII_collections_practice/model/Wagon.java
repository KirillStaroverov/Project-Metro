package jII_collections_practice.model;

import java.util.LinkedList;

/**
 * Класс Вагона
 */
public class Wagon {
    /**
     * Максимальная вместимость вагона
     */
    public static final int MAX_CAPACITY = 10;

    /**
     * Является ли вагон "головным"
     */
    private boolean isHeaderWagon;

    /**
     * Wagon name
     */
    private String name;

    /**
     * Список пассажиров вагона
     */
    private LinkedList<Passenger> passengers;

    public Wagon(String name, boolean isHeaderWagon) {
        this.name = name;
        this.isHeaderWagon = isHeaderWagon;
        passengers = new LinkedList<>();
    }

    public boolean isHeaderWagon() {
        return isHeaderWagon;
    }

    public void setHeaderWagon(boolean isHeaderWagon) {
        this.isHeaderWagon = isHeaderWagon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Wagon [head=" + isHeaderWagon + ", name=" + name + "]";
    }

    public LinkedList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(LinkedList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }
}
