package jII_collections_practice.model;

import java.util.LinkedList;

/**
 * Класс для Линии метро
 */
public class Line {
    /**
     * Название линии
     */
    private String name;
    /**
     * Список поездов этой линии
     */
    private LinkedList<Train> lineTrains;
    /**
     * Список станций этой линии
     */
    private LinkedList<Station> lineStations;

    public Line(String name) {
        this.name = name;
        this.lineStations = new LinkedList<>();
        this.lineTrains = new LinkedList<>();
    }

    /**
     * Add train to line
     *
     * @param train train to add
     */
    public void addTrain(Train train) {
        this.lineTrains.add(train);
        train.setTrainLine(this);
    }

    @Override
    public String toString() {
        return "\nLine [name=" + name + lineTrains + "]";
    }

    public LinkedList<Train> getLineTrains() {
        return lineTrains;
    }

    public void setLineTrains(LinkedList<Train> lineTrains) {
        this.lineTrains = lineTrains;
    }

    public LinkedList<Station> getLineStations() {
        return lineStations;
    }

    public void setLineStations(LinkedList<Station> lineStations) {
        this.lineStations = lineStations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
