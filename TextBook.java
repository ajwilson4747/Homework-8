
public class TextBook {
	private String textBook; 
	private String sku; 
	private double price; 
	private int quantity; 
	
	public TextBook(String sku, String textBook, double price, int quantity) {
		this.price=price; 
		this.quantity=quantity; 
		this.sku=sku; 
		this.textBook=textBook; 
	}
	
	public String getSKU() {
		return sku;
	}
	
	public String getTitle() {
		return textBook;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuant() {
		return quantity;
	}
	
	public String toString() {
		return sku + " " +  textBook +  " " + quantity;
	}
}
