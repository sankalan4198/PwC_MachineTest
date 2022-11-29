package main.java.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.java.BaseTest;

public class HomePageElements extends BaseTest {
	
	public static final WebElement popUp=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	public static final WebElement searchBar= driver.findElement(By.className("_3704LK"));
	public static final WebElement searchButton=driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));

	
	public static final WebElement Filters_text=driver.findElement(By.xpath("//span[text()='Filters']"));
}
