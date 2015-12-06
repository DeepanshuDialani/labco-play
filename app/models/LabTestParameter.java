package models;

public class LabTestParameter {
	
	private int id;
	
	private String name;
	
	public LabTestParameter(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
