package gowtham;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test1avd { 

	public static void main(String[] args) throws Exception {
    Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
    Thread.sleep(50000);
    URL u=new URL("http://0.0.0.0:4723/wd/hub");
    DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(CapabilityType.BROWSER_NAME, "");
	dc.setCapability("deviceName","emulator-5554");
	dc.setCapability("platformName", "android");
	dc.setCapability("platformVersion", "4.2.2");
	dc.setCapability("appPackage","com.android.calculator2");
	dc.setCapability("appActivity","com.android.calculator2.Calculator");
	//launch app
	AndroidDriver driver = new AndroidDriver(u,dc);
	Thread.sleep(5000);
	//automate code
	
	//close app	driver.closeApp();
	
	//stop appium server
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
