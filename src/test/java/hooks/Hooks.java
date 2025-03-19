package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import stepDefinitions.Base;

public class Hooks extends Base{

	@Before
	public void Browersetup() throws IOException
	{
	prop =new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\CucumberPOM\\src\\test\\resources\\config.properties");
	prop.load(fis);
	String brw=prop.getProperty("browser");
	if(brw.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
		driver=new ChromeDriver();
		//System.out.println(brw);
	}
	}	
	
	@After
    public void tearDown(Scenario scenario) throws IOException {
//      File file;
//        if (scenario.isFailed()) {
//            String screenshotPath = System.getProperty("user.dir") + "\\target\\screenshots\\"+scenario.getName()+"\\";
//            file = new File(screenshotPath);
//            file.mkdir();
//            try {
//                final File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(scrFile, new File(screenshotPath+"screenshot.png"));
//
//            } catch (final Exception e) {
//                e.printStackTrace();
//            }
//            String failedScreenShot = screenshotPath+"screenshot.png";
//            String url = "<img src="+failedScreenShot+" alt='failed screenshot'>";
//           // scenario.attach(url.getBytes(),"png", "Click Here To See Screenshot");
//            scenario.attach(url.getBytes(),"png", url);
		
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());

		}
//		else
//		{
//			TakesScreenshot ts=(TakesScreenshot) driver;
//			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", "Screenshot is attached");
//		}
//        
        }
	
    }

