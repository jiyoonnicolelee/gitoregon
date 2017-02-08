package oregon;

import java.util.Scanner;

public class Mode {
	int budget;
	String desc;
	String name;

	public Mode(int budget, String desc, String name){
		this.budget = budget;
		this.desc = desc;
		this.name = name;
	}
	
	public static Mode[] setupModes(){
		Mode[] modes = new Mode [3];
			
		
		modes[0]= new Mode(1600, "A rich, fat banker. The wealth of the banker, "
				+ "may hep getting started on the strip to Oregon.", "Banker");
		modes[1]=new Mode(800, "A middle-class guy. He has a smaller budget than the banker, "
				+ "but will earn more points for his sucess.", "Carpenter");
		modes [2] = new Mode (400,"A working-class farmer, "
				+ "poor",   "Farmer");
		return modes;
	}
	
	public static Mode chooseMode(Mode[] modes){
		Scanner input = new Scanner (System.in);
		
		System.out.println("Which character would you like to play?");
		for(int i=0; i<modes.length; i++){
			if(modes[i]==null) continue;
				System.out.printf("%d. %-9s: %s%n", i+1, modes[i].name, modes[i].desc);
		}
		
		while(true){
			if(input.hasNextInt()){
				int choice = input.nextInt();
				if((choice < 1 || choice > modes.length) || modes[choice -1] == null){
					//Create error output
					System.out.println("true");
					continue;
				}
				return modes[choice-1];
			} else {
				System.out.println("Please enter a number!");
				input.nextLine();
			}
			
		}
	}
	
}
