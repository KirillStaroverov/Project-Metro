package jII_collections_practice.service;

import jII_collections_practice.model.Line;
import jII_collections_practice.model.Station;
import jII_collections_practice.model.Train;
import jII_collections_practice.model.Wagon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/**
 * Metro factory
 *
 * @author Danny Briskin (sql.coach.kiev@gmail.com)
 * on  27.07.2017 for jII_collections_practice project.
 */
public class MetroFactory {

    /**
     * Creates wagons for depot collection. Approx. 30% of header wagons will be
     * created
     */
    public static LinkedList<Wagon> createDepot(int numberOfWagons) {
        LinkedList<Wagon> depot = new LinkedList<>();

        Random random = new Random();
        for (int i = 0; i < numberOfWagons; i++) {
            Wagon wgn = new Wagon("wagon " + i, (random.nextInt(100) < 30));
            depot.add(wgn);
        }
        return depot;
    }

    /**
     * Creates allTrains from depot wagons using train
     * {@link Train#addWagon addWagon} method. <br>
     * Adds ready to go train to allTrains collection
     *
     * @param depot - the depot with wagons
     * @return collection of  {@link Train}
     */
    public static HashSet<Train> createTrains(LinkedList<Wagon> depot) {

        HashSet<Train> allTrains = new HashSet<>();
        // наполнение поездов вагонами
        // максимальное количество поездов - размер депо / на количество вагонов
        // в поезде
        int maxTrainsNumber = depot.size() / Train.MAX_NUMBER_OF_WAGONS;

        for (int j = 0; j < maxTrainsNumber; j++) {
            Train train = new Train("Train " + j, "00" + j);
            while (!depot.isEmpty()) {
                train.addWagon(depot.poll());
                if (train.wagons.size() == Train.MAX_NUMBER_OF_WAGONS)
                    break;
            }
            if (train.readyToGo)
                allTrains.add(train);
        }
        return allTrains;
    }

    /**
     * Creates three lines. Adds them to metroKiev collection.
     *
     * @param metro the Metro
     */
    public static void createLines(HashMap<String, Line> metro) {
        for (String lineName : new String[]{"Red", "Blue", "Green"}) {
            metro.put(lineName, new Line(lineName));
        }
    }

    /**
     * Add stations to the lines(line station collection).
     *
     * @param metro the Metro
     */
    public static void createLineStations(HashMap<String, Line> metro) {
        for (int i = 0; i < 10; i++) {
            for (Line line : metro.values()) {
                line.getLineStations().add(new Station(line.getName() + "Station " + i));
            }
        }
    }

}
