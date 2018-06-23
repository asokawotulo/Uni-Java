package item;

public class DrinkItem {
	private String itemCode;
	private int quantity;
	
	public DrinkItem(String x, int y){
		itemCode = x;
		quantity = y;
	}
	
	public void setItemCode(String cd){
		itemCode = cd;
	}
	
	public void setQuantity(int qty){
		quantity = qty;
	}
	
	public String getItemCode(){
		return itemCode;
	}
	
	public int getQuantity(){
		return quantity;
	}
}
