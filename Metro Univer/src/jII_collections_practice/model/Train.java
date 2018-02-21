package jII_collections_practice.model;

import java.util.LinkedList;

/**
 * Класс для Поезда метро
 *
 */
public class Train {

	/**
	 * Максимальное количество вагонов в поезде
	 */
	public static final byte MAX_NUMBER_OF_WAGONS = 5;

	private String name;
	private String number;

    /**
     * Line where train moves in
     */
	private Line trainLine;

	/**
	 * Может ли поезд выходить на линию
	 */
	public boolean readyToGo;

	/**
	 * Машинист поезда
	 */
	private Driver driver;

	/**
	 * Вагоны поезда
	 */
	public LinkedList<Wagon> wagons;

	public Train(String name, String number) {
		this.name = name;
		this.number = number;
		wagons = new LinkedList<>();
		readyToGo = false;
	}

	/*
	 * Является ли первый вагон "головным"
	 * 
	 * @return true, если да, является
	 */
	private boolean hasHeaderWagon() {
		if (wagons.size() >= 1)
			if (wagons.getFirst().isHeaderWagon())
				return true;
		return false;
	}

	/*
	 * Является ли последний вагон "головным"
	 * 
	 * @return true, если да, является
	 */
	private boolean hasTrailerWagon() {
		if (wagons.size() >= 1)
			if (wagons.getLast().isHeaderWagon())
				return true;
		return false;
	}

	/**
	 * Добавление вагона в поезд
	 * 
	 * @param wagon
	 *            - вагон для добавления
	 */
	public void addWagon(Wagon wagon) {
		if (this.wagons.size() < MAX_NUMBER_OF_WAGONS) {
			if (wagon.isHeaderWagon() & !hasHeaderWagon())
				wagons.addFirst(wagon);
			else {
				if (wagon.isHeaderWagon() & !hasTrailerWagon())
					wagons.addLast(wagon);
				else {
					if (!hasHeaderWagon() || !hasTrailerWagon())
						wagons.add(wagon);
					else
						wagons.add(1, wagon);
				}
			}
			readyToGo = hasHeaderWagon() & hasTrailerWagon() & (this.wagons.size() == MAX_NUMBER_OF_WAGONS);

		} else
			System.out.println("Can't add more wagons!");
	}


	@Override
	public String toString() {
		return "\n Train [name=" + name + ", ready=" + readyToGo + ", num=" + number
				+ ", driver=" + driver + "]";
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

    public Line getTrainLine() {
        return trainLine;
    }

    public void setTrainLine(Line trainLine) {
        this.trainLine = trainLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
