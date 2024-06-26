package com.sause.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream(
					"./src/main/java/com/sause/configurations/config.properties");
			prop.load(fip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Intialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			opt.addArguments("--remote-allow-origins=*");
			//
			 Map<String, Object> prefs = new HashMap<String, Object>();
	            prefs.put("download.default_directory",
	                    System.getProperty("user.dir") + File.separator
	                            + "DownloadedFiles");
	            opt.setExperimentalOption("prefs", prefs); 
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(opt);

		} 
		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Manjunath Butna\\Downloads\\geckodriver-v0.33.0-win64");
			driver = new FirefoxDriver();
		}
		else if (browsername.equals("edge")) {
			
			System.setProperty("Webdriver.edge.driver", "C:\\Users\\Manjunath Butna\\Downloads\\edgedriver_win64");
			driver = new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		//driver.manage().timeouts().setScriptTimeout();
		
		driver.get(prop.getProperty("url"));


	}
	
	public static int generateRandomDigits(int n) {
		int m = (int) Math.pow(10, n - 1);
		return m + new Random().nextInt(9 * m);
	}
	
	public void deleteFile(String filePath) {
		
		File fileToDelete = new File(filePath);
		if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("File deleted successfully: " + filePath);
            } else {
                System.out.println("Failed to delete the file: " + filePath);
            }
        } else {
            System.out.println("File does not exist: " + filePath);
        }
		
	}
	
//	public void failedCase() throws IOException {
//		
//	//	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
//		Date date = new Date();
//		String actualdate = format.format(date);
//		try {
//			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			
//		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir"+ "/DownloadedFiles/" +actualdate+".png")));
//		}
//		catch(IOException e){
//			e.printStackTrace();
//		}
//	}
}
