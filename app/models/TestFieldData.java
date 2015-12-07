package models;

public class TestFieldData {
	private String fieldName;
	
	private String normalValue;
	
	private String value;
	
	private boolean isNormal;
	
	public TestFieldData(String fieldName, String normalValue, String value,
			boolean isNormal) {
		this.fieldName = fieldName;
		this.normalValue = normalValue;
		this.value = value;
		this.isNormal = isNormal;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public String getNormalValue() {
		return normalValue;
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean isNormal() {
		return isNormal;
	}
}
