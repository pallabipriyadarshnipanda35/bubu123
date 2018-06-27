package gowtham;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test5 {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input 1");
		String x=sc.nextLine();
		System.out.println("Enter input 2");
		String y=sc.nextLine();
		int i;
		int j;
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(50000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
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
		//lunch appium server
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//Enter input 1
		for(i =0; i <= x.length(); i++);
		{
			char c=x.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
			Thread.sleep(5000);
		}
		driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
		Thread.sleep(5000);
		//Enter input 2
		for(j =0;j<= y.length(); j++);
		{
			char c=y.charAt(j);
			driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
			Thread.sleep(5000);
		}
		driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
		String z=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
		//Validate out-put
		int a=Integer.parseInt(x);
		int b=Integer.parseInt(y);
		int c=Integer.parseInt(z);
		if(c==a+b)
		{
			System.out.println("Test pass");
		}
		else 
		{
			System.out.println("Test failed");
			DateFormat df=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
			Date d=new Date();
			String imageName=df.format(d);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("D://bubu//"+imageName+".png");
			FileUtils.copyFile(src, dest);
			
		}
		//close app
		driver.closeApp();
		Thread.sleep(5000);
		//close appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM  cmd.exe");
	}

}
