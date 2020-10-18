package game;

import java.time.LocalTime;
import java.time.Duration;

public class Pet {
	String name = "";
	String hungerStatus = "", happinessStatus = "", healthStatus = "", energyStatus = "", cleanlinessStatus = "";
	//pet traits
	long age, happiness, hunger, 
		health, cleanliness, energy;
	int discipline = 0;
	LocalTime prevTime = LocalTime.now();
	//conditions to see if pet is hungry n stuff
	boolean isSick = false;
	boolean isDirty = false;
	boolean isDead = false;
	
	public Pet(String name) {
		this.name = name;
		this.age = 0;
		this.happiness = 100;
		this.hunger = 100;
		this.health = 100;
		this.energy = 100;
		this.cleanliness = 100;
		
		this.setStatus(0);
		this.prevTime = LocalTime.now();
	}
	
	public void die() {
		isDead = true;
		hunger = 0;
		happiness = 0;
		energy = 0;
		cleanliness = 0;
		health = 0;
	}
	
	public String status() {
		checkTimeElapsed();
		setStatus(0);
		String status = this.name + " is currently ";
		if (isDead) {
			return status + "dead.";
		}
		else {
			status += " alive. ";
			status += hungerStatus;
			status += happinessStatus;
			status += energyStatus;
			status += cleanlinessStatus;
			status += healthStatus;
			status += "Age: " + age + " seconds old"; 
			return status;
		}
	}
	
	public long checkTimeElapsed() {
		long timeElapsed = Duration.between(prevTime, LocalTime.now()).toSeconds(); 
		//modifies stats based on how much time has passed by
		age = timeElapsed + age;
		happiness -= timeElapsed/4;
		hunger -= timeElapsed/2;
		cleanliness -= timeElapsed/3;
		energy = energy + timeElapsed/2 > 100 ? 100 : energy + timeElapsed/2;
		health -= timeElapsed / 5;
		isSick = isDirty && health < 50 ? true : false;
		if (isSick)
			health -= timeElapsed / 5;
		prevTime = LocalTime.now();
		return timeElapsed;
	}
	public boolean equals(Pet p) {
		if (this.status() == p.status()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String setStatus(int i) {
		checkTimeElapsed();
		//happiness checks
		if (happiness > 75) 
			happinessStatus = name + " is very happy! ";
		else if (happiness > 50) 
			happinessStatus = name + " is happy. ";
		else if (happiness > 25) 
			happinessStatus = name +" is not happy. ";
		else 
			happinessStatus = name +" is depressed! ";
		//hunger checks
		if (hunger > 75) 
			hungerStatus = name +" is well fed! ";
		else if (hunger > 50) 
			hungerStatus = name +" is moderately fed. ";
		else if (hunger > 25) 
			hungerStatus = name +" is underfed. ";
		else if (hunger > 0) 
			hungerStatus = name +" is starving! ";
		else 
			this.die();
		//health checks
		if (health > 75) 
			healthStatus = name +" is healthy! ";
		else if (health > 50) 
			healthStatus = name +" is fit. ";
		else if (health > 25) 
			healthStatus = name +" is unhealthy. ";
		else if (health > 0) {
			healthStatus = name +" is very unhealthy! ";
			isSick = true;
		}
		else 
			this.die();
		//cleanliness checks
		if (cleanliness > 50) {
			isDirty = false;
			cleanlinessStatus = name + " is clean. ";
		}
		else { 
			isDirty = true;
			cleanlinessStatus = name + " is dirty. ";
		}
		//energy checks
		if (energy > 75) 
			energyStatus = name + " is energetic. ";
		else if (energy > 50) 
			energyStatus = name + " is awake. ";
		else if (energy > 25) 
			energyStatus = name + " is tired. ";
		else 
			energyStatus = name + " is worn out. ";
		//returns status based on number. for just status checking, it doesnt matter which number is used
		switch (i) {
			case 0:
				return hungerStatus;
			case 1:
				return happinessStatus;
			case 2:
				return healthStatus;
			case 3:
				return cleanlinessStatus;
			case 4:
				return energyStatus;
			default:
				return "";
		}
	}
}
