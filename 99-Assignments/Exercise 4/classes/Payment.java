package classes;
import item.Item;
import item.FoodItem;
import item.DrinkItem;

public class Payment {
	private int fiCount = 0; //Alternative initialize
	private FoodItem[] fi = new FoodItem[100];
	private static double foodTax = 0.2; // 20 % sales tax added to 
	// all food prices 

	private int diCount = 0; //Alternative initialize
	private DrinkItem[] di = new DrinkItem[100];
	private static double drinkTax = 0.1; // 10 % sales tax added to 
	// all drink prices 

	public Payment() {} 

	// Drink
	public DrinkItem getDi(int x) { 
		return di[x]; 
	}
	public int getDiCount() { 
		return diCount;
	}
	public double getDrinkTax() { 
		return drinkTax;
	}
	// Food
	public FoodItem getFi(int x) { 
		return fi[x];
	}
	public int getFiCount() { 
		return fiCount;
	}
	public double getFoodTax() { 
		return foodTax;
	}

	// all other accessor and mutator methods are included 
	public void addFoodItem(FoodItem f){
		fi[fiCount] = f;
		fiCount++;
	}
	public void addDrinkItem(DrinkItem d){
		di[diCount] = d;
		diCount++;
	}

	// Calculate bill
	public double calculateBill(Item[] items){
		double total = 0;
		for(int i = 0; i < fiCount; i++){
			for(int j = 0; j < 200; j++){
				if(items[j].getCode().equals(fi[i].getItemCode())){
					total += items[j].getPrice();
				}
			}
		}
		for(int i = 0; i < diCount; i++){
			for(int j = 0; j < 200; j++){
				if(items[j].getCode().equals(di[i].getItemCode())){
					total += items[j].getPrice();
				}
			}
		}
		return total;
	}

	// public static double findPrice(Item[] pl, String c) {
	// 	//code missing } 
	// 	// calculateBill() – This method returns the bill (the total value of 
	// 	// the items consumed for a particular table)
	// }
}