package models;

import java.util.List;

public class LabTest {
	
	private int id;

	private String name;

	private int price;
	
	private List<LabTestParameter> parameters;
	
	public LabTest(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public LabTest(int id, String name, List<LabTestParameter> parameters) {
		this(id, name);
		this.parameters = parameters;
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
	
	public List<LabTestParameter> getParameters() {
		return parameters;
	}
}
