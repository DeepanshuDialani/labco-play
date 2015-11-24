package models;

import com.google.gson.annotations.SerializedName;

public class LabTest {
	
	private int id;

	private String name;

	private int price;
	
	public LabTest(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
