package utils;

import java.util.ArrayList;

import models.DetailRecord;
import models.TestFieldData;

import com.google.gson.Gson;


public class Utils {

	public static String toJSON(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	
	public static DetailRecord getDummyDetailRecord() {
    	ArrayList<TestFieldData> fields = new ArrayList<>();
    	fields.add(new TestFieldData("RBC", "4.7 - 6.1", "4.8", true));
    	fields.add(new TestFieldData("WBC", "4500 - 10000", "4300", false));
    	fields.add(new TestFieldData("Reticulocytes", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("PCV", "13.5 - 17.5", "19.5", false));
    	fields.add(new TestFieldData("MCV", "13.5 - 17.5", "11", false));
    	fields.add(new TestFieldData("MCH", "13.5 - 17.5", "14", true));
    	fields.add(new TestFieldData("Red cell morphology", "0.15-1.5%", "1.6", false));
    	fields.add(new TestFieldData("Target cells", "13.5 - 17.5", "16", true));
    	fields.add(new TestFieldData("Ovalocytes", "13.5 - 17.5", "14.3", true));
    	fields.add(new TestFieldData("Spherocytes", "4500 - 10000", "5400", true));
    	fields.add(new TestFieldData("Sickle cells", "13.5 - 17.5", "16.7", true));
    	fields.add(new TestFieldData("Nucleated Red cells", "13.5 - 13.8", "13.5", true));
    	fields.add(new TestFieldData("Anisocytosis", "13.5 - 17.5", "15.4", true));
    	fields.add(new TestFieldData("Microcytosis", "13.5 - 17.5", "14.6", true));
    	fields.add(new TestFieldData("Anisochromasia", "13.5 - 17.5", "19.5", false));
    	fields.add(new TestFieldData("Punctate Basiophilia", "13.5 - 17.5", "11.5", false));
    	fields.add(new TestFieldData("Poikilocytosis", "13.5 - 17.5", "16.5", true));
    	fields.add(new TestFieldData("Hypochromasia", "13.5 - 17.5", "14.4", true));
    	fields.add(new TestFieldData("Polychromasia", "13.5 - 17.5", "16.2", true));
    	fields.add(new TestFieldData("Platelet Morphology", "100,000-400,000", "250,000", true));
    	fields.add(new TestFieldData("WBC", "13.5 - 17.5", "19.5", false));
    	fields.add(new TestFieldData("White cell", "13.5 - 17.5", "14.2", true));
    	fields.add(new TestFieldData("Morphology", "13.5 - 17.5", "11.6", false));
    	fields.add(new TestFieldData("Myeloblasts", "13.5 - 17.5", "12.4", false));
    	fields.add(new TestFieldData("Promyelocytes", "13.5 - 17.5", "13.5", true));
    	fields.add(new TestFieldData("Myelocytes", "13.5 - 17.5", "19.5", false));
    	fields.add(new TestFieldData("Metamyelocyte", "13.5 - 17.5", "9.2", false));
    	fields.add(new TestFieldData("Polymorphs", "13.5 - 17.5", "17.12", true));
    	fields.add(new TestFieldData("Eosinophils", "1-3%", "2.3%", true));
    	fields.add(new TestFieldData("Basophils", "0-0.75%", "0.41%", true));
    	fields.add(new TestFieldData("Lymphocytes", "25-33%", "11.5%", false));
    	fields.add(new TestFieldData("Monocytes", "3-7%", "4.6%", true));
    	fields.add(new TestFieldData("Plasma cells", "13.5 - 17.5", "13.5", true));
    	fields.add(new TestFieldData("Abnormal cells", "13.5 - 17.5", "14.3", true));
    	fields.add(new TestFieldData("Parasites", "13.5 - 17.5", "14.6", true));
    	fields.add(new TestFieldData("ESR", "13.5 - 17.5", "16.3", true));
    	DetailRecord record = new DetailRecord(1, "Sukbhir Singh", "Male", "Blood", fields);
    	
    	return record;
    }
}
