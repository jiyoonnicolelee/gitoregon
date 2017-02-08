package oregon;

import java.text.DecimalFormat;

public class Store {
	//Implement the default price of times as static values
	
	//private static int oxen...
	private static int oxen_def = 20_00;
	private static int clothing_def = 10_00;
	private static int food_def = 0_20;//(cents per pound)
	private static int ammo_def = 0_10;
	private static int wheel_def = 10_00;
	private static int axle_def = 10_00;
	private static int tongue_def = 10_00;
	
	//private int oxen...
	public int money;
	public int oxen;	
	public int clothing;
	public int food;
	public int ammo;
	public int wheel;
	public int axle;
	public int tongue;

	private int value;	
	
	public Store (double multiplier){
		food = (int) (food_def * multiplier);
		oxen= (int)(oxen_def * multiplier);
		clothing = (int)(clothing_def * multiplier);
		ammo = (int) (ammo_def * multiplier);
		wheel = (int) (wheel_def * multiplier);
		tongue= (int) (tongue_def * multiplier);
		axle = (int) (axle_def * multiplier);
	}
	
	public String getPrice(int value){
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format((double)value/100);
		}
}