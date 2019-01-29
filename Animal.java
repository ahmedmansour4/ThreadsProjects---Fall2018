/* This class develops the animals and runs the race they take part in.
 * 
 */
public class Animal extends Thread implements Runnable {

	private String name; //Name of the animal
	private int position; //The position of the animal, as in how far they have traveled
	private int speed; //The speed the animal moves at
	private int restMax; //The maximum time the animal could rest
	private static boolean winner = false; //Flag to determine when a winner is found
	private Food food; //Food object to allow animals to eat
	
	Animal(String name, int position, int speed, int restMax, Food food) {
		setAnimalName(name);
		setPosition(position);
		setSpeed(speed);
		setRestMax(restMax);
		setFood(food);
	}
	
	public void setAnimalName(String name) {
		this.name = name;
	}
	
	public String getAnimalName() {
		return name;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setRestMax(int restMax) {
		this.restMax = restMax;
	}
	
	public int getRestMax() {
		return restMax;
	}
	
	public void setFood(Food food) {
		this.food = food;
	}
	
	public Food getFood() {
		return food;
	}
	
	@Override
	public void run() { //This is the method that is excecuted when the start() method is called.
		int rand = (int)(Math.random() * restMax); //a random number is generated between 0 and the restMax value
		while(position <= 100 && !winner) { //The race will continue while each animal is not yet passed 100 yards and a winner has not been called yet.
			System.out.println(toString()); //Prints information about each animal
			position += speed; //The animal is moved forward according to their speed
			try {
				Thread.sleep(rand); //The animal rests for a random amount of time, simulated here be causing the thread to sleep
				
			} catch (InterruptedException e) { //catch is needed if the sleeping thread is interuppted
				
			}
			System.out.println(name + " started eating!"); 
			food.eat(restMax); //The animal pauses to eat, simulated here by causing the thread to sleep
			System.out.println(name + " stopped eating!");
			
		}
		if(position >= 100) { //if the animal is passed 100 yards, it is declared the winner
			winner = true;
			System.out.println("\n--------------------------------------------------------------------\nThe winner of this race is: " + name + "!");
		}

	} //Once the while loop is exited, the run() method terminate, which ends both threads.
	public String toString() {
		return name + " is " + (100 - position) + " yards away from the goal!";
	}
	
}
