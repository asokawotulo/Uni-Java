package item;

public class Item {
	private String code;
	private String name;
	private double price;
	
	public void setCode(String cd){
		code = cd;
	}
	
	public void setName(String nm){
		name = nm;
	}
	
	public void setPrice(double prc){
		price = prc;
	}
	
	public String getCode(){
		return code;
	}
	
	public String getName(){
		return name;
	}

	public double getPrice(){
		return price;
	}

	public Item(String c, String n, double p) {
		code = c;
		name = n;
		price = p;
	}
}
