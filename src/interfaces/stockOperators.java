package interfaces;

import java.util.ArrayList;

import classes.Stock;

public interface stockOperators {
	public abstract void addStock(String name, double price, double quantity, String tag);

	public void searchStock(String name);
	
	public void editStock(String name, double price, double quantity, String tag);
	
	public void deleteStock(String name);

	public ArrayList<Stock> listStock();
}
