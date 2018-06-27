package gowtham;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test3 {

	
	public static void main(String[] args) throws Exception {
		 //start appium server	
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(50000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		Thread.sleep(20000); 
		//provide device details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.calculator2");
		dc.setCapability("appActivity","com.android.calculator2.Calculator");
		dc.setCapability("skipUnlock", true);
		Thread.sleep(5000);
		//Lunch app
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//Automate 9+5
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@text='9']")).click();
		
		driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
		
		driver.findElement(By.xpath("//*[@text='5']")).click();
		
		driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
		
		String x=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
		System.out.println(x);
		
		//close app
		driver.closeApp();
		//Thread.sleep(5000);
		//close appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM  cmd.exe");
		
		

	}

}
