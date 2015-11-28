package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.LabTest;
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
			return ok(labrecords.render());
		}
		else {
			return unauthorized("Easy bro!");
		}
	}

	private boolean validateLoginFormData(Map<String, String[]> loginFormData) {
		String inputEmail = loginFormData.get(Constants.EMAIL_LOGIN_KEY)[0];
		String inputPassword = loginFormData.get(Constants.PASSWORD_LOGIN_KEY)[0];
		// TODO: Validate from db
		return inputEmail.equals("admin@labco.com") && inputPassword.equals("admin");
	}
    
	public Result logout() {
	    session().remove(Constants.AUTH_TOKEN_KEY);
	    return ok("Bye");
	}

    public Result newReport() {
    	List<LabTest> labTestsResponse = getLabTests("validAuthToken");
    	return ok(newreport.render(labTestsResponse));
    }
    
    private List<LabTest> getLabTests(String authToken) {
//    	 TODO: Fetch lab tests from db
    	List<LabTest> labTests = new ArrayList<>();
    	labTests.add(new LabTest(123, "Blood"));
    	labTests.add(new LabTest(224, "Dengue"));
    	return labTests;
    }
}
