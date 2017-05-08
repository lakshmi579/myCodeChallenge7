package challenges.challenge;


	
	import java.util.Random;
	import java.util.concurrent.BlockingQueue;

	
	public class Randomizer implements Runnable{
	  
		//Shared Queue 1 for random numbers
		private final BlockingQueue<Integer> sharedQueue1;
		//Shared Queue 2 for random numbers
		private final BlockingQueue<String> sharedQueue2;

		/**
		 * 
		 * @param sharedQueue1
		 * @param sharedQueue2
		 * Initializing queues with Prime instantiation
		 */
	    public Randomizer(BlockingQueue<Integer> sharedQueue1,BlockingQueue<String> sharedQueue2) {
	        this.sharedQueue1 = sharedQueue1;
	        this.sharedQueue2 = sharedQueue2;
	    }

	    /**
	     * Method to generate Random number using Java API
	     * @return
	     */
		public  int generateRandomNumber() {
			Random rand = new Random();
			return ( 1 + rand.nextInt((1000 - 1) + 1));
		}

		@Override
		public void run() {
			
			try {
				int number = generateRandomNumber();// generating random number 
				sharedQueue1.put(number);//storing random number in a queue
			} catch (InterruptedException e) {
				e.printStackTrace();//printing exception stack on console
			}
			if(null != sharedQueue2 && sharedQueue2.size() > 0){//if the queue is not null & size more then zero
				try {
					String result = sharedQueue2.take();//take out the top most element from queue
					System.out.println(result);//printing the number in a console				
				} catch (InterruptedException e) {
					e.printStackTrace();//printing the exception stack trace in a console
				}
				
			}//end if

			//executing while loop forever
			while(true){
				try {
					Thread.sleep(2000);//Making the thread to sleep for 2 secs
				} catch (InterruptedException e) {
					e.printStackTrace();//printing the exception stack trace on a console
				}
				run();//calling run method
			}//end while
		}//end of run method
	}


