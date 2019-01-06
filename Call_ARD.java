package appium_basics;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
ort org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Call_ARD
{
	public static void main(String[] args) throws Exception 
	{
		//Gety a mobile number
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter mobile number");
		String mbno= sc.nextLine();
		//Start Appium server and form URL for it
e.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723 \" ");
		URL u= new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("Appium server started");

		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","47ebca7d0104");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.0");
		dc.setCapability("appPackage","com.android.contacts");
		dc.setCapability("appActyDialer");
		System.out.println("properties are set");
		//Launch app in ARD
		AndroidDriver driver;
		while(true)
		{
			try 
			{
			driver = new AndroidDriver(u,dc); 
			break;
			}
			catch(Exception e)
			{
			}
		}
		//App Automation
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Contacts']")));
			Thread.sleep(5000);
			for(int i=0;i<mbno.length();i++)
			{
				char d =rAt(i);
				String w="";
				switch(d)
				{
				case '0' :
					w= "zero";
					break;
				case '1' :
					w= "one";
					break;
				case '2' :
					w= "two";
					break;
				case '3' :
					w= "three";
					break;
				case '4' :
					w= "four";
					break;
				case '5' :
					w= "five";
					break;
				case '6' :
					w= "six";
					break;
				case '7' :
					w= "seven";
					break;
				case '8' :
					w= "eight";
					break;
				case '9' :
					w= "nine";
					break;
				}
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='"+w+"']")));
				driver.findElement(By.xpath("//*[@content-desc='"+w+"']")).click();
			}
			//call
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Dial using SIM2']")));
			driver.findElement(By.xpath("//*[@content-desc='Dial using SIM2']")).click();
			Thread.sleep(10000);
			//Endcall
			try
			{
				if(drive.xpath("//*[@content-desc='End']")).isDisplayed())
				{
					driver.findElement(By.xpath("//*[@content-desc='End']")).click();
					Thread.sleep(5000);
				}
			}
			catch(Exception e)
			{
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		driver.closeApp();
		//Stop Appium Server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Appium server stoped");
	}

}
