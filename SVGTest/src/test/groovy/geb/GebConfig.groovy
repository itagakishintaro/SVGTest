import geb.report.ScreenshotReporter

import org.openqa.selenium.chrome.ChromeDriver


reportsDir = "D:/work/gebreport"

driver = {
	System.setProperty('webdriver.chrome.driver', 'webdriver/chromedriver.exe')
	new ChromeDriver()
}

reporter = new ScreenshotReporter() {
	@Override
	protected escapeFileName(String name) {
		// name.replaceAll("[^\\w\\s-]", "_")
		name.replaceAll('[\\\\/:\\*?\\"&lt;>\\|]', '_')
	}
}