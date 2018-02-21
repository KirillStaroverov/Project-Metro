package jII_collections_practice.starter;

import jII_collections_practice.model.Escalator;
import jII_collections_practice.model.Passenger;
import jII_collections_practice.model.Station;
import jII_collections_practice.model.Vestibul;
import jII_collections_practice.service.Metro;

/**
 * ÐŸÑ€Ð°ÐºÑ‚Ð¸ÐºÐ° Ð¿Ð¾ ÐºÐ¾Ð»Ð»ÐµÐºÑ†Ð¸Ñ�Ð¼
 * 
 * ÐšÐ¸ÐµÐ²Ñ�ÐºÐ¾Ðµ Ð¼ÐµÑ‚Ñ€Ð¾. 1. ÐšÐ°Ð¶Ð´Ñ‹Ð¹ Ð¿Ð¾ÐµÐ·Ð´ Ð¼ÐµÑ‚Ñ€Ð¾ Ñ�Ð¾Ñ�Ñ‚Ð¾Ð¸Ñ‚ Ð¸Ð· 5 Ð²Ð°Ð³Ð¾Ð½Ð¾Ð². Ð¢Ñ€Ð¸ Ð¸Ð· ÐºÐ¾Ñ‚Ð¾Ñ€Ñ‹Ñ…
 * Ð¼Ð¾Ð³ÑƒÑ‚ Ð±Ñ‹Ñ‚ÑŒ Ð»ÑŽÐ±Ñ‹Ð¼Ð¸, Ð° Ð¿ÐµÑ€Ð²Ñ‹Ð¹ Ð¸ Ð¿Ð¾Ñ�Ð»ÐµÐ´Ð½Ð¸Ð¹ Ñ‚Ð¾Ð»ÑŒÐºÐ¾ Ð¾Ð¿Ñ€ÐµÐ´ÐµÐ»Ñ‘Ð½Ð½Ð¾Ð³Ð¾ Ñ‚Ð¸Ð¿Ð° (Ð³Ð¾Ð»Ð¾Ð²Ð½Ñ‹Ðµ
 * Ð²Ð°Ð³Ð¾Ð½Ñ‹). Ð’ Ð²Ð°ÑˆÐµÐ¼ Ñ€Ð°Ñ�Ð¿Ð¾Ñ€Ñ�Ð¶ÐµÐ½Ð¸Ð¸ ÐµÑ�Ñ‚ÑŒ Ð´ÐµÐ¿Ð¾ Ñ� Ð²Ð°Ð³Ð¾Ð½Ð°Ð¼Ð¸, Ð½Ð°Ð±Ñ€Ð°Ð½Ð½Ñ‹Ð¼Ð¸ Ñ�Ð»ÑƒÑ‡Ð°Ð½Ñ‹Ð¼
 * Ð¾Ð±Ñ€Ð°Ð·Ð¾Ð¼. Ð¡Ñ„Ð¾Ñ€Ð¼Ð¸Ñ€ÑƒÐ¹Ñ‚Ðµ Ð½ÐµÑ�ÐºÐ¾Ð»ÑŒÐºÐ¾ Ð¿Ð¾ÐµÐ·Ð´Ð¾Ð². ÐšÐ°Ð¶Ð´Ñ‹Ð¹ Ð²Ð°Ð³Ð¾Ð½ Ð¸Ð¼ÐµÐµÑ‚ Ñ�Ð²Ð¾Ð¹ Ð½Ð¾Ð¼ÐµÑ€,
 * Ñ�Ð¾Ñ�Ñ‚Ð¾Ñ�Ñ‰Ð¸Ð¹ Ð¸Ð· Ð½Ð¾Ð¼ÐµÑ€Ð° Ð¿Ð¾ÐµÐ·Ð´Ð° Ð¸ ÐµÐ³Ð¾ Ð¿Ð¾Ñ€Ñ�Ð´ÐºÐ¾Ð²Ð¾Ð³Ð¾ Ð½Ð¾Ð¼ÐµÑ€Ð° Ð² Ñ�Ð¾Ñ�Ñ‚Ð°Ð²Ðµ. Ð¡Ð¾Ð±Ñ€Ð°Ð² Ð¿Ð¾ÐµÐ·Ð´Ð°,
 * Ð¿Ñ€Ð¾Ð²ÐµÑ€ÑŒÑ‚Ðµ, Ñ‡Ñ‚Ð¾ Ð¾Ð½Ð¸ Ð¼Ð¾Ð³ÑƒÑ‚ ÐµÑ…Ð°Ñ‚ÑŒ (Ñƒ Ð½Ð¸Ñ… ÐµÑ�Ñ‚ÑŒ Ð¾Ð´Ð¸Ð½ Ð³Ð¾Ð»Ð¾Ð²Ð½Ð¾Ð¹ Ð¸ Ð¾Ð´Ð¸Ð½ ÐºÐ¾Ð½ÐµÑ‡Ð½Ñ‹Ð¹
 * Ð²Ð°Ð³Ð¾Ð½ Ð¸ Ð²Ð°Ð³Ð¾Ð½Ð¾Ð² Ð²Ñ�ÐµÐ³Ð¾ 5). 2. Ð£ Ð²Ð°Ñ� Ð½Ðµ Ð´Ð¾Ð»Ð¶Ð½Ð¾ Ð±Ñ‹Ñ‚ÑŒ Ð¾Ð´Ð¸Ð½Ð°ÐºÐ¾Ð²Ñ‹Ñ… Ð¿Ð¾ÐµÐ·Ð´Ð¾Ð².
 * Ð’Ñ‹Ð¿ÑƒÑ�Ñ‚Ð¸Ñ‚Ðµ Ð¿Ð¾ÐµÐ·Ð´Ð° Ð½Ð° Ñ‚Ñ€Ð¸ Ð»Ð¸Ð½Ð¸Ð¸ Ð¼ÐµÑ‚Ñ€Ð¾(Ð¿Ð¾Ð¾Ñ‡ÐµÑ€Ñ‘Ð´Ð½Ð¾ Ð·Ð°Ð¿Ð¾Ð»Ð½Ñ�Ñ� Ð»Ð¸Ð½Ð¸Ð¸). Ð Ð°Ñ�Ñ�Ð°Ð´Ð¸Ñ‚Ðµ Ð²
 * ÐºÐ°Ð¶Ð´Ñ‹Ð¹ Ð¿Ð¾ÐµÐ·Ð´ Ð¼Ð°ÑˆÐ¸Ð½Ð¸Ñ�Ñ‚Ð¾Ð², Ð² Ð·Ð°Ð²Ð¸Ñ�Ð¸Ñ�Ð¼Ð¾Ñ�Ñ‚Ð¸ Ð¾Ñ‚ Ð¸Ñ… Ð¾Ð¿Ñ‹Ñ‚Ð°(Ð½Ð° Ð¿ÐµÑ€Ð²Ñ‹Ð¹ Ð¿Ð¾ÐµÐ·Ð´ Ñ�Ð°Ð´Ð¸Ñ‚Ñ�Ñ�
 * Ñ�Ð°Ð¼Ñ‹Ð¹ Ð¾Ð¿Ñ‹Ñ‚Ð½Ñ‹Ð¹). ÐŸÐ¾Ñ�Ð»Ðµ Ð¾ÐºÐ¾Ð½Ñ‡Ð°Ð½Ð¸Ñ� Ñ€ÐµÐ¹Ñ�Ð° Ð¾Ð¿Ñ‹Ñ‚ Ð¼Ð°ÑˆÐ¸Ð½Ð¸Ñ�Ñ‚Ð° ÑƒÐ²ÐµÐ»Ð¸Ñ‡Ð¸Ð²Ð°ÐµÑ‚Ñ�Ñ�. Ð¡ÐºÐ¾Ñ€Ð¾Ñ�Ñ‚ÑŒ
 * Ð¿Ñ€Ð¸Ñ€Ð¾Ñ�Ñ‚Ð° Ð¾Ð¿Ñ‹Ñ‚Ð° Ð¿Ð°Ð´Ð°ÐµÑ‚ Ð¿Ð¾ Ð¼ÐµÑ€Ðµ ÐµÐ³Ð¾ Ð½Ð°ÐºÐ¾Ð¿Ð»ÐµÐ½Ð¸Ñ�. 3. Ð”Ð°Ð»ÐµÐµ, Ð¿Ð¾ÐµÐ·Ð´Ð° Ð¿Ñ€Ð¸Ð±Ñ‹Ð²Ð°ÑŽÑ‚ Ð½Ð°
 * Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ð¸ Ñ�Ð²Ð¾ÐµÐ¹ Ð»Ð¸Ð½Ð¸Ð¸. Ð¡ Ð¿Ñ€Ð¸Ð±Ñ‹Ñ‚Ð¸ÐµÐ¼ Ð¿Ð¾ÐµÐ·Ð´Ð°, Ð½Ð° ÐºÐ°Ð¶Ð´Ð¾Ð¹ Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ð¸ Ð¿Ð¾Ñ�Ð²Ð»Ñ�ÐµÑ‚Ñ�Ñ�
 * Ð½ÐµÑ�ÐºÐ¾Ð»ÑŒÐºÐ¾ Ð¿Ð°Ñ�Ñ�Ð°Ð¶Ð¸Ñ€Ð¾Ð². Ð�Ð° ÐºÐ°Ð¶Ð´Ð¾Ð¹ Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ð¸ Ð¸Ð· Ð²Ð°Ð³Ð¾Ð½Ð° Ð²Ñ‹Ñ…Ð¾Ð´Ð¸Ñ‚ Ñ�Ð»ÑƒÑ‡Ð°Ð½Ð¾Ðµ Ñ‡Ð¸Ñ�Ð»Ð¾
 * Ð¿Ð°Ñ�Ñ�Ð°Ð¶Ð¸Ñ€Ð¾Ð². ÐŸÐ¾Ñ�Ð»Ðµ Ñ�Ñ‚Ð¾Ð³Ð¾ Ð² Ð²Ð°Ð³Ð¾Ð½Ñ‹ Ñ�Ð°Ð´Ð¸Ñ‚Ñ�Ñ� Ð¼Ð°ÐºÑ�Ð¸Ð¼Ð°Ð»ÑŒÐ½Ð¾ Ð²Ð¾Ð·Ð¼Ð¾Ð¶Ð½Ð¾Ðµ Ñ‡Ð¸Ñ�Ð»Ð¾
 * Ð¿Ð°Ñ�Ñ�Ð°Ð¶Ð¸Ñ€Ð¾Ð² Ð¸Ð· Ñ‡Ð¸Ñ�Ð»Ð° Ð½Ð°Ñ…Ð¾Ð´Ñ�Ñ‰Ð¸Ñ…Ñ�Ñ� Ð½Ð° Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ð¸. Ð’ Ð²Ð°Ð³Ð¾Ð½ Ð¼Ð¾Ð¶ÐµÑ‚ Ñ�ÐµÑ�Ñ‚ÑŒ Ð¾Ð³Ñ€Ð°Ð½Ð¸Ñ‡ÐµÐ½Ð½Ð¾Ðµ
 * Ñ‡Ð¸Ñ�Ð»Ð¾ Ð¿Ð°Ñ�Ñ�Ð°Ð¶Ð¸Ñ€Ð¾Ð². Ð•Ñ�Ð»Ð¸ Ð¼ÐµÑ�Ñ‚ Ð±Ð¾Ð»ÑŒÑˆÐµ Ð½ÐµÑ‚, Ð¿Ð°Ñ�Ñ�Ð°Ð¶Ð¸Ñ€Ñ‹ Ð¾Ð¶Ð¸Ð´Ð°ÑŽÑ‚ Ñ�Ð»ÐµÐ´ÑƒÑŽÑ‰Ð¸Ð¹ Ð¿Ð¾ÐµÐ·Ð´. 4.
 * ÐŸÐ¾Ñ�Ð»Ðµ Ð¿Ñ€Ð¾ÐµÐ·Ð´Ð° Ð²Ñ�ÐµÑ… Ð¿Ð¾ÐµÐ·Ð´Ð¾Ð² Ð²Ñ‹Ð²ÐµÐ´Ð¸Ñ‚Ðµ Ñ�Ð¿Ð¸Ñ�Ð¾Ðº Ð¿Ð°Ñ�Ñ�Ð°Ð¶Ð¸Ñ€Ð¾Ð² Ð½Ð° ÐºÐ¾Ð½ÐµÑ‡Ð½Ñ‹Ñ… Ñ�Ñ‚Ð°Ð½Ñ†Ð¸Ñ�Ñ…
 * Ð²Ñ�ÐµÑ… Ð»Ð¸Ð½Ð¸Ð¹.
 *
 * 
 */
public class TestPractice {

	/**
	 * Starts here
	 * @throws Exception 
	 * 
	 */
	public static void main(String[] args) {

		Metro metro;

		// creating the Metro
		metro = new Metro();
		
		
		

 		metro.distributeTrainsToLines();
 		System.out.println(metro.metroKiev.values());

		System.out.println("--=================================================--");
 
		try {
			metro.manageDriversQueue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("--=================================================--");

//		metro.movePassengersInOutTrains();
        System.out.println("--=================================================--");
//		metro.showPassengersLeft();
        

        
//        Station testsStation = new Station("Test");
//        Vestibul vestibul = new Vestibul();
//        
//        new Thread(new Runnable() {
//        	public void run()
//
//        	
//        	{
//        		int i = 0;       		
//	        		while(true){
//	        			Passenger passanger = new Passenger("Test" + i);
//	        			
//	        			vestibul.vestibulPassengers.add(passanger);
//	        			
//	        			vestibul.mLock.lock();
//	        			vestibul.hasEnoughPassengers.signalAll();
//	        			vestibul.mLock.unlock();
//	        			
//	        			System.out.println("Passenger:" + passanger + " entered vestibul");
//	        			i++;
//	        			try {
//							Thread.sleep(1500);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//	        		}	
//        		
//        	}
//        }).start();
//        
////        try {
////			Thread.sleep(4000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//        
//        Escalator escalator1 = new Escalator(testsStation, vestibul, "Escalator 1");
//        Escalator escalator2 = new Escalator(testsStation, vestibul, "Escalator 2");
//        Escalator escalator3 = new Escalator(testsStation, vestibul, "Escalator 3");
//        
//        Thread thread1 = new Thread(escalator1);
//        Thread thread2 = new Thread(escalator2);
//        Thread thread3 = new Thread(escalator3);
//        
//        thread1.start();
//        thread2.start();
//        thread3.start();
        
        
	}

}
