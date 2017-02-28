package oregon;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Store {
	//Implement the default price of times as static values
	
	//private static int oxen...
	double multiplier;
	
	public void Interact(Mode mode){
		while(true){		
			itemList(mode);
			int item = getUserInput(mode);
			if(item == -1) return;
			getQuantity(item, mode);
		}
	}
	
	public Store (double multiplier){
		this.multiplier = multiplier;
	}
	

	public String getPrice(int value){
		value = (int) ((double)value*this.multiplier);
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format((double)value/100);
		}
	
	public void itemList(Mode mode){
		Inventory inv=Inventory.getInventory(mode);
		
		System.out.println();
		for(int i=0; i < inv.items.size(); i++){
			//1. Oxen				$20.00
		    //2. Clothing			$10.00
		System.out.printf("%d. %-8s\t$%5s\n", i+1, inv.items.get(i).name, getPrice(inv.items.get(i).def_price));
		}

		System.out.println("---------------------------------------------------");
		System.out.println("You have: \t$"+inv.readMoney());
		
		
		System.out.println("Hey, let me know if you're interested in something!");
		System.out.println("Enter 0 to exit the store.");
	}
	
	public int getUserInput(Mode mode){
		Scanner input = new Scanner(System.in);
		Inventory inv = Inventory.getInventory(mode);
		int choice;
		while(true){
			while (!input.hasNextInt()){
				System.out.println("Please enter a number between 0 and "+ inv.items.size()+"!");
				input.nextLine();
			}
			choice = input.nextInt();
			choice--;
			
			if(choice >=-1 && choice <= inv.items.size()-1){
				return choice;
			}
			System.out.println("Your options are between 0 and"+inv.items.size()+"!");
		}
	}
	public void getQuantity(int item_num, Mode mode){
		Scanner input = new Scanner(System.in);
		Inventory inv = Inventory.getInventory(mode);
		int choice;
		System.out.println("How many "+inv.items.get(item_num).name+" do you want to buy?");
		while(true){
			while(!input.hasNextInt()){
				System.out.println("Please enter a whole number!");
				input.nextLine();	
			}
			choice = input.nextInt();
			
			if(choice >=0 && (inv.items.get(item_num).def_price * this.multiplier) * choice <= inv.money){
				//increase the item number by choice
				inv.items.get(item_num).num += choice;		
				
				//decrease money by choice*default price*multiplier
				//inv.itmes.money -= inv.items.money-
				inv.money = inv.money - (int)(inv.items.get(item_num).def_price*this.multiplier)*choice;
				
				//Output on purchase (Bought 3 oxen!)
				System.out.println("Bought " + choice + " " +inv.items.get(item_num).name+"!");
				return;
			}
			
			//Give better situational error output
			if(choice < 0){
			System.out.println("Please input a whole number.");
			}
			
			if((int)(inv.items.get(item_num).def_price*this.multiplier)*choice > inv.money){
			System.out.println("You don't have enough money!");
			}
			
			
			}
		}
	}