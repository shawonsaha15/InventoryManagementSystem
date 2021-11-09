package classes;

import java.util.ArrayList;

import interfaces.stockOperators;

public class Stock implements stockOperators {
	protected String name;
	protected double price;
	protected double quantity;
	protected String tag;

	public Stock() {
	}

	Stock(String name, double price, double quantity, String tag) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public void addStock(String name, double price, double quantity, String tag) {
		// TODO Auto-generated method stub
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.tag = tag;

		ArrayList<Stock> fullstock = new ArrayList<Stock>();
		fullstock.add(new Stock(name, price, quantity, tag));

		GetData gd = new GetData();
		gd.fileWriteStock(fullstock);
	}

	@Override
	public void searchStock(String name) {
		// TODO Auto-generated method stub
		this.name = name;

		GetData gd = new GetData();
		ArrayList<Stock> fullstock = gd.fileStockCheck(name);
		try {
		this.price = fullstock.get(0).price;
		this.quantity = fullstock.get(0).quantity;
		this.tag = fullstock.get(0).tag;}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editStock(String name, double price, double quantity, String tag) {
		// TODO Auto-generated method stub
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.tag = tag;
		
		ArrayList<Stock> fullstock = new ArrayList<Stock>();
		fullstock.add(new Stock(name, price, quantity, tag));
		
		GetData gd = new GetData();
		
		gd.fileStockEdit(name, fullstock);
	}

	@Override
	public void deleteStock(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
		GetData gd = new GetData();
		
		gd.fileStockDelete(name);
	}

	@Override
	public ArrayList<Stock> listStock() {
		// TODO Auto-generated method stub
		GetData gd = new GetData();
		
		ArrayList<Stock> list = gd.fileStockList();
		
		return list;
	}

}
