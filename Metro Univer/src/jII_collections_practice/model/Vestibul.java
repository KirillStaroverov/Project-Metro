package jII_collections_practice.model;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Vestibul {

		public LinkedList<Passenger> vestibulPassengers = new LinkedList<Passenger>();
		public Lock mLock = new ReentrantLock();
		
		public Condition hasEnoughPassengers = mLock.newCondition();
		
		
		
		
	

}
