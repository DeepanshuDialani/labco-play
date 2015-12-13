package controllers;

import notifications.GCMConstants;
import notifications.GCMNotificationPayload;
import notifications.ReportNotificationData;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.ws.WS;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotificationsController extends Controller{

	public Result handleReportNotificationRequest() {
		WSRequest request = createGcmRequest();
		String payload = getGcmPayload();
		System.out.println("Requesting: " + request.getUrl() + ", data: " + payload);
		Promise<WSResponse> responsePromise = request.post(payload);
		if(responsePromise != null) {
			responsePromise.map(new Function<WSResponse, JsonNode>() {
				@Override
				public JsonNode apply(WSResponse response) throws Throwable {
					System.out.println("Response: " + response.getBody());
					return null;
				}
			});
	    	responsePromise.recoverWith(new Function<Throwable, Promise<WSResponse>>() {
	    	    @Override
	    	    public Promise<WSResponse> apply(Throwable throwable) throws Throwable {
	    	    	System.out.println("Report notification exception: " + throwable);
					return WS.url("http://backup.example.com").get();
	    	    }
	    	});
		}
		else {
			System.out.println("Response promise is null");
		}
		return ok("notification sent");
    }
	
	private WSRequest createGcmRequest() {
		WSRequest request = WS.url("https://gcm-http.googleapis.com/gcm/send");
    	request.setRequestTimeout(3000);
    	request.setContentType("application/json");
    	request.setHeader("Authorization", "key=" + GCMConstants.API_KEY);
		return request;
	}
	
	private String getGcmPayload() {
		ObjectMapper mapper = new ObjectMapper();
    	String payload = null;
		try {
			ReportNotificationData reportData = new ReportNotificationData(Utils.getDummyDetailRecord());
			String registrationId = "cjH_dcBYtB8:APA91bGiUddT23H0duOEZPxVwQ51lDV6yUVB2a12hAmoOn8oqbXX6AM6HKFyvFyQeTR3zB2wHv4XejZqIMnzzI_i1IoH1Z9PkKk0-0D_fWwMnNqx5NNRdHvWpet_MZZaZNAhhoTWJQIz";
			payload = mapper.writeValueAsString(new GCMNotificationPayload(registrationId, reportData));
		} catch (JsonProcessingException e) {
			System.out.println("Error while generating json from GCM payload: "+ e);
		}
		return payload;
	}
	
}
