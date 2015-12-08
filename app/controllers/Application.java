package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.DetailRecord;
import models.LabTest;
import models.LabTestParameter;
import models.TestFieldData;
import play.*;
import play.mvc.*;
import play.mvc.Http.RequestBody;
import utils.Constants;
import utils.Utils;
import views.html.*;

public class Application extends Controller {

	public Result index() {
		String user = session(Constants.AUTH_TOKEN_KEY);
	    if(user != null) {
	    	// Logged in
	        return ok(labrecords.render());
	    } else {
	        return ok(login_page.render());
	    }
    }

	public Result login() {
		RequestBody body = request().body();
		Map<String, String[]> loginFormData = body.asFormUrlEncoded();
		boolean validLogin = validateLoginFormData(loginFormData);
		if(validLogin) {
			// TODO: session valid authToken
			String authToken = "sampleAuth";
			session(Constants.AUTH_TOKEN_KEY, authToken);
			return redirect("/");
		}
		else {
			return unauthorized("Password & username don't match");
		}
	}

	private boolean validateLoginFormData(Map<String, String[]> loginFormData) {
		String inputEmail = loginFormData.get(Constants.EMAIL_LOGIN_KEY)[0];
		String inputPassword = loginFormData.get(Constants.PASSWORD_LOGIN_KEY)[0];
		// TODO: Validate from db
		return inputEmail.equals("kem@elixr.co") && inputPassword.equals("kem");
	}
    
	public Result logout() {
	    session().remove(Constants.AUTH_TOKEN_KEY);
	    return redirect("/");
	}

    public Result newReport() {
    	List<LabTest> labTestsResponse = getLabTests("validAuthToken");
    	return ok(newreport.render(labTestsResponse));
    }

    private List<LabTest> getLabTests(String authToken) {
//    	 TODO: Fetch lab tests from db
    	List<LabTest> labTests = new ArrayList<>();
    	labTests.add(new LabTest(345, "Blood"));
    	labTests.add(new LabTest(346, "Dengue"));
    	return labTests;
    }
    
    private List<LabTest> getLabTestsWithParameters(String authToken) {
//   	 TODO: Fetch lab tests from db
	   	List<LabTest> labTests = new ArrayList<>();
	   	labTests.add(new LabTest(345, "Blood", getBloodParameters()));
	   	labTests.add(new LabTest(346, "Dengue", getDengueParameters()));
	   	return labTests;
   }
    
    private List<LabTestParameter> getBloodParameters() {
    	List<LabTestParameter> parameters = new ArrayList<LabTestParameter>();
    	parameters.add(new LabTestParameter(3456, "RBC"));
    	parameters.add(new LabTestParameter(3457, "Hb"));
    	parameters.add(new LabTestParameter(3458, "Reticulocytes"));
    	parameters.add(new LabTestParameter(3459, "PCV"));
    	parameters.add(new LabTestParameter(3460, "MCV"));
    	return parameters;
    }
    
    private List<LabTestParameter> getDengueParameters() {
    	List<LabTestParameter> parameters = new ArrayList<LabTestParameter>();
    	parameters.add(new LabTestParameter(4456, "D1"));
    	parameters.add(new LabTestParameter(4457, "D2"));
    	parameters.add(new LabTestParameter(4458, "D3"));
    	return parameters;
    }

    public Result detailRecord(Long id) {
    	return ok(detailrecord.render(getDetailRecord()));
    }
    
    private DetailRecord getDetailRecord() {
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
    
    public Result analytics() {
    	return ok(analytics.render(getLabTestsWithParameters("validAuthToken")));
    }
}