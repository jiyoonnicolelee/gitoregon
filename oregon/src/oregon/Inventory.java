package oregon;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Inventory {
	public int money;
	
	Item oxen;
	Item clothing;
	Item food;
	
	Item ammo;
	Item wheels;
	Item axles;
	Item tongues;
	
	ArrayList<Item> items = new ArrayList<>();

	private static Inventory inv;
	//Singleton class 
	
	public String readMoney(){
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format((double)money / 100);
	}
	
	private Inventory (int money){
		this.money = money * 100;
	}
	
	public static Inventory getInventory(Mode mode){
		if(inv == null){
			inv = new Inventory(mode.budget);
						
			inv.food = new Item("Food",         0_20);
			inv.oxen = new Item("Oxen",        20_00);
			inv.clothing = new Item("Clothing", 10_00);
			inv.ammo = new Item("Ammo",         0_10);
			inv.wheels = new Item("Wheels",   10_00);
			inv.tongues = new Item("Tongues",  10_00);
			inv.axles = new Item("Axles",      10_00);
			
			inv.items.add(inv.food);
			inv.items.add(inv.oxen);
			inv.items.add(inv.clothing);
			inv.items.add(inv.ammo);
			inv.items.add(inv.wheels);
			inv.items.add(inv.tongues);
			inv.items.add(inv.axles);
		}
		return inv;
	}
	
}
