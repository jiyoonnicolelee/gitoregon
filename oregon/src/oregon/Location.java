package oregon;

public class Location {
	String name;
	
	public static Location[] Locations = {
			new Town("Independence", new Store(1)),
			new River("Kansas River", 7, 100, 3, false),
			new River ("Big Blue River", 7, 100, 5, false),
			new Town ("Fort Kearney", new Store(1.25)),
			new Landmark ("Chimney Rock"),
			new Town ("Fort Laramie", new Store(1.5)),
			new Landmark ("Independence Rock"),
			new Town("South Pass", new Store(1.75)),
			new Town("Fort Bridger", new Store(1.75)),
			new River("Green River Crossing", 7, 100, 1, false),
			new Landmark ("Soda Springs"),
			new Town("Fort Hall", new Store(2)), 
			new River("Snake River Crossing", 7, 100, 5, true),
			new Town("Fort Boise", new Store(2.25)),
			new Landmark("Blue Mountains"),
			new Town("Fort Walla Walla", new Store(2.5)),
			new Landmark("The Dalles"),
			new River("Coumbia River", 5, 100, 4, false),//maybe change later
			new Landmark("The Oregon City")			
	};
	
public static int[][][] adjacencyList = 
	{
			/*0*/{{1, 102}},
			/*1*/{{2, 83}},
			/*2*/{{3, 119}},
			/*3*/{{4, 250}},
			/*4*/{{5, 86}},
			/*5*/{{6, 190}},
			/*6*/{{7, 102}},
			/*7*/{{8, 94}, {9, 144}},
			/*8*/{{9, 144}},
			/*9*/{{10, 144}},
			/*10*/{{11, 57}},
			/*11*/{{12, 182}},
			/*12*/{{13, 114}},
			/*13*/{{14, 160}},
			/*14*/{{15, 3}, {16, 10}},
			/*15*/{{16, 52}},
			/*16*/{{17, 52}},
			/*17*/{{18, 0}}
	};
	
	public Location(String name){
		this.name = name;
	}
}
