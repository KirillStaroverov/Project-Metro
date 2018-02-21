package jII_collections_practice.model;

import java.util.LinkedList;

/**
 * Класс для Станции
 *
 */
public class Station {
	/**
	 * Имя станции
	 */
	private String name;
	/**
	 * Список пассажиров на станции
	 */
	private LinkedList<Passenger> waitingPassengers;

	public Station(String name) {
		this.name = name;
		this.waitingPassengers = new LinkedList<Passenger>();
	}

	@Override
	public String toString() {
		return "Station [" + name + "; waiting passengers (" + waitingPassengers.size() + ")]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Passenger> getWaitingPassengers() {
		return waitingPassengers;
	}

	public void setWaitingPassengers(LinkedList<Passenger> waitingPassengers) {
		this.waitingPassengers = waitingPassengers;
	}

    public void addPassengerToPlatform(Passenger passenger) {
	    this.waitingPassengers.add(passenger);
    }
}
