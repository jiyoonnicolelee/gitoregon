package oregon;

public class Game {

		public static void main(String[] arsg){
			Mode[] modes = Mode.setupModes();// set up classes
			Mode mode = Mode.chooseMode(modes);
			System.out.println(mode.name);
			Character[] members = Character.setMembersName();//sets members names
			
			System.out.print("Yay!");
			Inventory inventory =Inventory.getInventory(mode);		
			Store first = new Store(1);
			first.Interact(mode);
			
			CurrentDate date = CurrentDate.getCurrentDate();
			
			for(int i=0;i<100;i++){
				System.out.println("Today is "+ date.outputDate());
				date.daysForward(1);
			}
			
			/*System.out.println(inventory.readMoney());
			
			Store first = new Store(1);		
			System.out.println("Ox at first store costs: "+first.getPrice(first.oxen));
			Store second = new Store(1.25);
			System.out.println("Ox at second store costs: "+second.getPrice(second.oxen));*/
		}
}