package config;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports {

	private static ExtentHtmlReporter htmlReporter;

	public static ExtentHtmlReporter createInstance(String fileName) {
		htmlReporter = new ExtentHtmlReporter(fileName);

		// Chart location - top, bottom
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);

		// Make the charts visible on report open
		htmlReporter.config().setChartVisibilityOnOpen(true);

		// Theme - standard, dark
		htmlReporter.config().setTheme(Theme.STANDARD);

		// Report title
		htmlReporter.config().setDocumentTitle("Automation Report - Amazon");

		// Append Tests to Existing Report
		htmlReporter.setAppendExisting(true);

		// Protocol (http, https)
		htmlReporter.config().setProtocol(Protocol.HTTPS);

		// Encoding, default = UTF-8
		htmlReporter.config().setEncoding("utf-8");

		// Report or build name
		htmlReporter.config().setReportName("Amazon Report");

		// Set timeStamp format
		// htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");

		return htmlReporter;
	}
}