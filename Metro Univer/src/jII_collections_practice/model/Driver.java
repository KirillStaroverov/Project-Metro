package jII_collections_practice.model;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;


/**
 * Класс для Машиниста
 */

public class Driver implements Runnable{
    /**
     * Имя машиниста
     */
    private String name;
    /**
     * Текущий опыт машиниста
     */
    private int experience;
    /**
     * Текущий поезд
     */
    private Train currentTrain;
    
    private BlockingQueue<Driver> driverQueue;

    public Driver(String name, int experience, BlockingQueue<Driver> driverQueue) {
        this.name = name;
        this.experience = experience;
        this.driverQueue = driverQueue;
    }

    /**
     * The driving process and experience recalculating.
     * Experience can be downgraded for one-threaded application purposes.
     */
    @Override
	public void run() {
		
    	doDrive();
    	
    	try {
			Thread.sleep(new Random().nextInt(3000)+1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			driverQueue.put(this);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
    
    public void doDrive() {
        Random rnd = new Random();
        System.out.println("Driver " + this.name + " drives " + this.currentTrain.getName());
        this.experience += rnd.nextInt(80);
    }

    @Override
    public String toString() {
        return "Driver [name=" + name + ", experience=" + experience + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }

    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
        currentTrain.setDriver(this);
    }

	

}
