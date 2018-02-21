package jII_collections_practice.model;

public class Escalator implements Runnable {

	private Station station;
	private Vestibul vestibul;
	private String escalatorName;

	public Escalator(Station station, Vestibul vestibul, String escalatorName) {
		super();
		this.station = station;
		this.vestibul = vestibul;
		this.escalatorName = escalatorName;
	}

	@Override
	public void run() {

		while (true) {
			try {
				vestibul.mLock.lock();

				if (vestibul.vestibulPassengers.isEmpty()) {
					vestibul.hasEnoughPassengers.await();
				} else {
					Passenger passenger = vestibul.vestibulPassengers.remove();

					station.addPassengerToPlatform(passenger);
					System.out.println(passenger + " Moved to station from escalator: " + escalatorName);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				vestibul.mLock.unlock();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
