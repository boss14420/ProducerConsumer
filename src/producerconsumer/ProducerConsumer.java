/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boss14420
 */
public class ProducerConsumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(15);
            Producer p = new Producer(queue);
            p.setVisible(true);
            Thread tp = new Thread(p);
            
            Consumer c = new Consumer(queue);
            c.setLocation(500, 100);
            c.setVisible(true);
            Thread tc = new Thread(c);
            
            tp.start();
            Thread.sleep(3000);
            
            tc.start();
            
            tp.join();
            tc.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
