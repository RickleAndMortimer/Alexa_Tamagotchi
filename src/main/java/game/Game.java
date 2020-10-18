package game;

import java.util.HashSet;

public class Game {
	public static int maxStat = 100;
	public static HashSet<Pet> pets = new HashSet<Pet>();
	//functions
	static Pet selectPet(String input) {
		if (pets.size() > 0) {
			for (Pet p : pets) {
				if (p.name.equals(input)) 
					return p;
			}
		}
		return null;
	}
	//actions
	public static String createPet(String input) {
		Pet p = new Pet(input);
		pets.add(p);
		//debugging println statement only
		System.out.println(pets.size());
		return (input + " has been created successfully. Enjoy your new pet!");
	}
	
	public static String feed(String name) {
		Pet p = selectPet(name);
		if (p == null) 
			return "This pet could not be found";
		else if (p.hunger < maxStat) {
			p.hunger += 15;
			p.energy -= 5;
			return p.setStatus(0);
		} 
		else
			return name + " is too full! Try again later.";
	}
	
	public static String shower(String name) {
		Pet p = selectPet(name);
		if (p == null) 
			return "This pet could not be found";
		else if (p.energy > 10){
			p.cleanliness = 100;
			p.energy -= 10;
			return p.setStatus(3);
		}
		else {
			return name + " is too tired right now. Try again later";
		}
	}
	
	public static String play(String name) {
		Pet p = selectPet(name);
		if (p == null) 
			return "This pet could not be found";
		else if (p.energy > 35) {
			p.happiness = p.happiness < 25 ? p.happiness + 10 : p.happiness + 25;
			p.energy -= 25;
			return p.setStatus(1);
		}
		else {
			return name + " is too tired right now. Try again later";
		}
	}  
	
	public static String giveMedicine(String name) {
		Pet p = selectPet(name);
		if (p == null) 
			return "This pet could not be found";
		else if (p.energy > 10) {
			p.health += 50;
			p.isSick = false;
			p.happiness -= 40;
			return p.setStatus(4);
		}
		else {
			return name + " is too tired right now. Try again later";
		}
	}  
	
	public static String checkStatus(String name) {
		Pet p = selectPet(name);
		if (p == null)
			return "This pet could not be found";
		return selectPet(name).status();
	}
	
	public static String checkAll() {
		String returntxt = "";
		if (pets.size() > 0) {
			for (Pet p : pets) {
				returntxt += p.status() + ", ";
			}
			return returntxt;
		}
		else 
			return "Error: there are no pets!";
	}
	
	@SuppressWarnings("deprecation")
	public static String stateTime() {
		return new Long(System.nanoTime()).toString();
	}
}
