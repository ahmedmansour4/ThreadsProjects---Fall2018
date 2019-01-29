/* This class tests the Animal class, by creating two Animal objects and running two threads at once.
 * 
 * Name: Ahmed Mansour
 * Date: 10/15/18
 */
public class ThreadsTester{

	public static void main(String[] args) {
		
		Food lettuce = new Food();
		Animal rabbit = new Animal("Jack the Rabbit", 0, 5, 140, lettuce); //Animal objects rabbit and turtle are initialized.
		Animal turtle = new Animal("Johnny the Turtle", 0, 3, 100, lettuce);
		
		
		rabbit.start(); //start methods create a new thread for the program to run on. Two threads will be created.
		turtle.start();
	}

}
