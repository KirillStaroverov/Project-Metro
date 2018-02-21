package jII_collections_practice.service;

import jII_collections_practice.model.*;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Metro {
	public final static int WAGONS_IN_DEPOT = 300;

	/**
	 * Депо с вагонами
	 */
	private LinkedList<Wagon> depot;
	/**
	 * Все поезда
	 */
	private HashSet<Train> allTrains;

	/**
	 * Всё метро
	 */
	public HashMap<String, Line> metroKiev;

	private Map<String, LinkedList<Passenger>> passengersLeftInStations;

	/**
	 * Constructs the Metro
	 */
	public Metro() {
		// 1. Depot creation
		depot = MetroFactory.createDepot(WAGONS_IN_DEPOT);
		// 2. Trains creation from wagons
		allTrains = MetroFactory.createTrains(this.depot);
		// 3. Metro creation
		metroKiev = new HashMap<>();
		MetroFactory.createLines(metroKiev);
		MetroFactory.createLineStations(metroKiev);
	}

	/**
	 * Adds allTrains from allTrains collection to a line allTrains.
	 */
	public void distributeTrainsToLines() {
		Iterator<Train> trainIterator = allTrains.iterator();
		while (trainIterator.hasNext()) {
			// you can also use a loop for Lines in the metroKiev here
			metroKiev.get("Red").addTrain(trainIterator.next());
			if (trainIterator.hasNext())
				metroKiev.get("Blue").addTrain(trainIterator.next());
			if (trainIterator.hasNext())
				metroKiev.get("Green").addTrain(trainIterator.next());
		}
	}

	/**
     * Creates drivers and froms a driver queue from them. Comparator of queue
     * is based on drivers experience. Run all allTrains with available drivers in
     * different threads After all threads are finished - print a resulting
     * queue
	 * @throws Exception 
     */
    public void manageDriversQueue() throws Exception {
        Comparator<Driver> comparator = new Comparator<Driver>() {
            @Override
            public int compare(Driver o1, Driver o2) {
                // to order Drivers in descending direction by their experience
                if (o1.getExperience() > o2.getExperience()) {
                    return -1;
                }
                if (o1.getExperience() < o2.getExperience()) {
                    return 1;
                }
                return 0;
            }
        };
        
        LinkedList<Thread> listOfThreads = new LinkedList<>();
        
        // creating Drivers Queue
        BlockingQueue<Driver> driverQueue = new PriorityBlockingQueue<>(10, comparator);

        driverQueue.add(new Driver("Konstantin", 8, driverQueue));
        driverQueue.add(new Driver("Kryvorukov I.I.", 29, driverQueue));
        driverQueue.add(new Driver("Petrovich", 56, driverQueue));
        driverQueue.add(new Driver("Stazher Seryozha", 6, driverQueue));

        // print the initial state of queue
        Util.printPriorityQueue(driverQueue, comparator);
        
        // Run drivers on trains
        for (Train train : allTrains) {
         //   if (!driverQueue.isEmpty()) {
        	
            	Driver currentDriver = driverQueue.take();
            	
            	Thread driverThread = new Thread(currentDriver);
            	
                currentDriver.setCurrentTrain(train);
                
                driverThread.start();
                
                listOfThreads.add(driverThread);
                
//                currentDriver.doDrive();
                
//                driverQueue.add(currentDriver);
           // }
        }
        
        
        for (Thread thread : listOfThreads){
        	try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        

        // print the final state of queue
        Util.printPriorityQueue(driverQueue, comparator);
    }

	/**
	 * Creating passengers and running all allTrains through stations
	 */
	public void movePassengersInOutTrains() {

		for (Line line : metroKiev.values()) {
			System.out.println("Start moving on " + line.getName() + " : ");
			Iterator<Train> trainIterator = line.getLineTrains().iterator();
			while (trainIterator.hasNext()) {
				Train train = trainIterator.next();
				System.out.println(
						" Train " + train.getName() + " {Driver : " + train.getDriver() + "} is starting move ");
				runTrainForLine(train);
			}
		}
	}

	/**
	 * Runs train through line. Train stays at every station and let passengers
	 * go out and in.
	 *
	 * @param train
	 *            - current train
	 */
	public void runTrainForLine(Train train) {
		Random rnd = new Random();
		// auxiliary variables to calculate number of variable
		int cntToOperate = 0, resultOper = 0;

		for (Station station : train.getTrainLine().getLineStations()) {
			cntToOperate = rnd.nextInt(45);
			// С прибытием поезда, на каждой станции появляется
			// несколько пассажиров.
			for (int i = 0; i < cntToOperate; i++) {
				station.addPassengerToPlatform(new Passenger("Passenger " + rnd.nextInt(1111)));
			}
			System.out.println("  arriving to " + station);

			// высадка пассажиров (если они есть) из вагонов
			// проходим по всем вагонам поезда
			for (Wagon wagon : train.wagons) {
				System.out.print("   " + wagon.getName() + " [" + wagon.getPassengers().size() + "] :  ");
				resultOper = 0;
				// если вагон не пуст
				if (!wagon.getPassengers().isEmpty()) {
					// проходим про всем пассажирам вагона
					Iterator<Passenger> passengerIterator = wagon.getPassengers().iterator();
					cntToOperate = rnd.nextInt(10);
					// выходит несколько пассажиров
					while (passengerIterator.hasNext() && cntToOperate > 0) {
						wagon.getPassengers().removeFirst();
						cntToOperate--;
						resultOper++;
					}
					System.out.print("   " + resultOper + " passengers leave; ");
				}

				// Пассажиры на станции садятся в вагоны (все, кто могут
				// поместиться)

				resultOper = 0;
				// если в вагоне есть место и на станции есть пассажиры
				while (wagon.getPassengers().size() < Wagon.MAX_CAPACITY & station.getWaitingPassengers().size() > 0) {
					wagon.addPassenger(station.getWaitingPassengers().poll());
					resultOper++;
				}
				System.out.print("" + resultOper + " passengers enter ");
				System.out.println("");
			}
		}
		System.out.println("");
	}

	/**
	 * Add remaining passengers into HashMap for quick find and print passengers
	 * list
	 */
	public void showPassengersLeft() {
		this.passengersLeftInStations = new HashMap<>();
		for (Line line : metroKiev.values()) {
			for (Station station : line.getLineStations()) {
				passengersLeftInStations.put(station.getName(), station.getWaitingPassengers());
			}
		}
		System.out.println("Passengers at end station of Red line:");
		for (Passenger pass : passengersLeftInStations.get("RedStation 9")) {
			System.out.println(" " + pass.getName());
		}
		System.out.println("Passengers at end station of Blue line:");
		for (Passenger pass : passengersLeftInStations.get("BlueStation 9")) {
			System.out.println(" " + pass.getName());
		}
		System.out.println("Passengers at end station of Green line:");
		for (Passenger pass : passengersLeftInStations.get("GreenStation 9")) {
			System.out.println(" " + pass.getName());
		}
	}
}
