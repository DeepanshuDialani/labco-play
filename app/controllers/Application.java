package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.DetailRecord;
import models.LabTest;
<<<<<<< HEAD
import models.LabTestParameter;
=======
import models.TestFieldData;
>>>>>>> fa16ccf376bcf50d1e37c4b2f644839ab9428f9a
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

    public Result detailRecord(Long id) {
    	return ok(detailrecord.render(getDetailRecord()));
    }
    
    private DetailRecord getDetailRecord() {
    	ArrayList<TestFieldData> fields = new ArrayList<>();
    	fields.add(new TestFieldData("RBC", "4.7 - 6.1", "4.5", false));
    	fields.add(new TestFieldData("WBC", "4500 - 10000", "5400", true));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("WBC", "4500 - 10000", "5400", true));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	fields.add(new TestFieldData("Hb", "13.5 - 17.5", "9.5", false));
    	DetailRecord record = new DetailRecord(1, "Akshay", "Male", "Blood", fields);
    	
    	return record;
    }
    
    public Result analytics() {
    	return ok(analytics.render(getLabTestsWithParameters("validAuthToken")));
    }
}
