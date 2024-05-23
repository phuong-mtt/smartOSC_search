# Documents
  1. Test stategy and test design: https://docs.google.com/spreadsheets/d/1vXBOxWcd9kJjTr2V47-UE4_TtcLjDj6pC4YmriZ_OJ0/edit#gid=933337903
  
# Run project
  1. Install IntelliJ, Maven 3.9.1, JDK 21
  2. Clone this git repository
  3. Install webDriver:
     + Visit https://developer.chrome.com/docs/chromedriver/downloads and download the WebDriver for your Chrome version.
     + Extract the downloaded file and place the `chromedriver.exe` executable in a folder within your project (e.g., `webdrivers`).
     + Get path containting that driver in your local device

  4. Go to src/main/java/utils/DriverInitializer.java and replace that path in System.setProperty("webDriver.chrome.driver", "{{yourPath}}");
  5. Go to src/test/java/runners/TestRunner.java then right click to run that file
  6. After running, go to target/cucumberReport.xml, you can see the report
  



