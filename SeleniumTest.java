package SKR.SeleniumTutorial;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		WebElement searchBox=driver.findElement(By.name("_nkw"));
		searchBox.sendKeys("books by coelho");
		searchBox.submit();
		
		String mainPage = driver.getWindowHandle();
		System.out.println("Main page="+ mainPage);
		
		driver.findElement(By.xpath("//li[@id='item21a35c1640']//div[@class='s-item__title']")).click();
		
		Set<String> allPages=driver.getWindowHandles();
		for(String page : allPages) {
			if(!page.equals(mainPage)) {
				driver.switchTo().window(page);
				break;
			}
		}
		System.out.println(driver.getCurrentUrl());
		List<WebElement> products= driver.findElements(By.className("ux-labels-values__values-content"));
		System.out.println(products.size()+"\n DELIVERY DETAILS:");
		for(WebElement product: products) {
			System.out.println(product.getText());
		}
		driver.findElement(By.xpath("//a[@id='atcBtn_btn_1']")).click();
	}

}
