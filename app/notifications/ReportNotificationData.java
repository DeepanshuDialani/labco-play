package notifications;

import models.DetailRecord;

public class ReportNotificationData {

	private DetailRecord reportData;

	public ReportNotificationData(DetailRecord reportData) {
		this.reportData = reportData;
	}

	public void setReportData(DetailRecord reportData) {
		this.reportData = reportData;
	}

	public DetailRecord getReportData() {
		return reportData;
	}
}
