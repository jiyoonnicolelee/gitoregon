package oregon;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CurrentDate {
	public static CurrentDate cDate;//Singleton instance
	
	Date date;
	
	public static long unix_march = 1488326400000L;
	public static long unix_april = 1491004800000L;
	public static long unix_may   = 1493596800000L;
	public static long unix_june  = 1496275200000L;
	public static long unix_july  = 1498867200000L;
	
	private CurrentDate (Date date){
		this.date = date;
	}
	
	public void daysForward(int days){
		//Create instance of calendar class
		Calendar cal = Calendar.getInstance();
		//Set time in the calendar object to the time of our date
		cal.setTime(this.date);
		//add a number of days to the date(number passed in as days)
		cal.add(Calendar.DATE, days);
		//assign the new date to the date object
		this.date = cal.getTime();
	}
	
	public int dayofTheWeek(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	//date.compareTo
	//date.after
	//date.before
	
	public String outputDate(){
		SimpleDateFormat df = new SimpleDateFormat("E, MMMM d");
		return df.format(this.date);
	}
	
	public static Date setupCurrentDate(){
		System.out.println("Which month would you like to start your journey?");
		long[] options= {unix_march, unix_april, unix_may, unix_june, unix_july};
		//1. Output options
		listDateOptions(options);
		//2. Get/Validate user input
		int response = getUserDepartureMonth(options);
		//3. Setup and return the Date object
		return new Date(options[response]);
	}
	
	private static int getUserDepartureMonth(long[] options){
		Scanner input = new Scanner(System.in);
		while(true){
			if(input.hasNextInt()){
				int choice = input.nextInt();
				if(choice < 1 || choice > options.length){
					//Create error output
					System.out.println("true");
					continue;
				}
				return choice-1;
			} else {
				System.out.println("Please enter a number!");
				input.nextLine();
			}
		}
	}
	
	public static void listDateOptions(long[] unix_timestamps){
		//turning these options into actual dates
		SimpleDateFormat df = new SimpleDateFormat("MMMM");
		Date[]dates = new Date[unix_timestamps.length];
		
		for (int i=0; i < unix_timestamps.length; i++){
			dates[i] = new Date(unix_timestamps[i]);
		}
		//Output
		for(int i=0; i< unix_timestamps.length; i++){
			System.out.printf("%d. %-7s%n", i+1, df.format(dates[i]));
		}
	}
	
	public static CurrentDate getCurrentDate(){
		//check if c date is null
		//if it is null, set it up
		//return cDate
		
		if(cDate == null){
			Date date = setupCurrentDate();
			cDate = new CurrentDate(date);
		}
		return cDate;
	}	
}

	
	//Create a method, which gives the user a choice between each of the start dates
	//A method for them to respond, with appropriate checks to make their response is valid
	//and instantiate the date object, using the appropriate Unix time
	//check the mode class, if you need hints
	
	/*public static chooseCurrentDate(){
		long[] = {unix_march, unix_april, unix_may, unix_june, unix_july};
		//for loop to output options
		return chooseCurrentDate;
	}

	public static CurrentDate chooseDate(){
	[] option = 
	
	date = new Date[c];
	//date = new Date(unix_march);*/