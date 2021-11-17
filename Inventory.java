import java.util.ArrayList;

public class Inventory {
	public static ArrayList <TextBook> bookList; 
	public static TextBook book;
	
	public Inventory() {
		bookList = new ArrayList<TextBook>();
	}
	
	//adding a book to the TextBook ArrayList 
	public static void addBook( String sku, String textBook, double price, int quantity) {
		book = new TextBook( sku,textBook, price, quantity);
		bookList.add(book);
	}
	
	//printing out the arraylist for debugging purposes 
	public static void generateReport() {
		for (int i=0; i<bookList.size(); i++) {
			System.out.println(bookList.get(i).toString());
		}
}	
	//THIS METHOD GETS CALLED IN THE VIEW CLASS
	//THIS LOOKS FOR INFO BASED ON A SKU STRING THE USER INPUTS 
	//If foud, display info
	//if not, display string error message 
	public static String displayBookInfo(String sku) {
			String result="";
			for(int i=0; i<bookList.size(); i++) {
				if(bookList.get(i).getSKU().contains(sku)) {
					result = "Title: " +bookList.get(i).getTitle()+ "\tSKU: " +bookList.get(i).getSKU()+ "\tPrice: " + bookList.get(i).getPrice() + "\tQuant: " + bookList.get(i).getQuant();	
				}
				else {
					result = "Book could not be found! ";
				}
			}
			return result;
		}
	//this method will remove a textbook from the arraylist which should update the file if rechecked 
	public static void removeText(String sku) {
		for(int i=0; i<bookList.size(); i++) {
			//System.out.println(bookList.get(i) + " ");
			//System.out.println("comparing " + sku + " with " + bookList.get(i).getSKU());
			if(bookList.get(i).getSKU().contains(sku)) {
				//System.out.println("found the sku");
				bookList.remove(i);
			}
		}
	}
	}
