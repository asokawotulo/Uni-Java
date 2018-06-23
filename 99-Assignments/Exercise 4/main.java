import item.Item;
import item.FoodItem;
import item.DrinkItem;
import classes.Payment;

public class main {
	public static double findPrice(Item[] items, String c){
		for(int i = 0; i < 200; i++){
			if(items[i].getCode().equals(c)){
				return items[i].getPrice();
			}
		}
		return 0;
	}

	public static void main(String[] args){
		Payment[] tables = new Payment[50];
		Item[] p1 = new Item[200];
		String c, n;
		double p;

		for(int i = 0; i < 200; i++){
			if(i < 100){
				c = "f" + i;
				n = "Food " + i;
				p = i * 2.1;
				p1[i] = new Item(c, n, p);
			} else {
				c = "d" + i;
				n = "Drink " + i;
				p = i * 3.4;
				p1[i] = new Item(c, n, p);
			}
		}

		tables[0] = new Payment();

		FoodItem a = new FoodItem("f99", 2);
		DrinkItem b = new DrinkItem("d102", 2);

		tables[0].addFoodItem(a);
		tables[0].addDrinkItem(b);
		System.out.println(tables[0].getFiCount());
		System.out.println(tables[0].getDiCount());

		System.out.println(tables[0].getFoodTax());
		System.out.println(tables[0].getDrinkTax());

		System.out.println(tables[0].getDi(0).getItemCode()); 

		System.out.println(tables[0].calculateBill(p1));
	}
}