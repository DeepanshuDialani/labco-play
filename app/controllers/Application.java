package controllers;

import java.util.ArrayList;
import java.util.List;

import models.LabTest;

import play.*;
import play.mvc.*;
import utils.Utils;
import views.html.*;

public class Application extends Controller {
    
	public Result index() {
    	String username = "Deepanshu";
        return ok(index.render(username));
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
