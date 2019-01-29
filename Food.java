/* This class allows the animal to pause and eat for a short time.
 * 
 */
public class Food {

	
	synchronized void eat(long eating) { //a synchrnoized method means that only once thread at a time can use it
		try {
			Thread.sleep(eating);
		} catch (InterruptedException e) {
		
		}
	}
}
