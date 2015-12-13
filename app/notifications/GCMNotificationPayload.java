package notifications;

import java.util.Map;

public class GCMNotificationPayload {
	
	private String to;
	
	private ReportNotificationData data;
	
	public GCMNotificationPayload(String to, ReportNotificationData data) {
		this.to = to;
		this.data = data;
	}
	
	public String getTo() {
		return to;
	}
	
	public ReportNotificationData getData() {
		return data;
	}
}
