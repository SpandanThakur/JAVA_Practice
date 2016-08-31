package com.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerBlockingQueue {
	   public static void main(String args[]){
		   
		     //Creating shared object
		     BlockingQueue sharedQueue = new LinkedBlockingQueue(2);
		 
		     //Creating Producer and Consumer Thread
		     Thread prodThread = new Thread(new ProducerBlockingQueue(sharedQueue));
		     Thread consThread = new Thread(new ConsumerBlockingQueue(sharedQueue));

		     //Starting producer and Consumer thread
		     prodThread.start();
		     consThread.start();
		    }
		 
}
class ProducerBlockingQueue implements Runnable {

    private final BlockingQueue sharedQueue;

    public ProducerBlockingQueue(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

//Consumer Class in Java
class ConsumerBlockingQueue implements Runnable{

    private final BlockingQueue sharedQueue;

    public ConsumerBlockingQueue(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
  
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
  
}

