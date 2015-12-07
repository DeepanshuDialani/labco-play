package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.DetailRecord;
import models.LabTest;
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
    	return ok(analytics.render());
    }
}
