//package com.project1.SeleniumTest.tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class SelTest {
//
//    public static void main(String[] args) {
//        String driverPath = "C:/Users/ahmed/training/2109-jwa-wvu/chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", driverPath);
//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        try{
//
//            driver.get("file:///C:/Users/ahmed/OneDrive/Desktop/p/Project1/Login.html");
//            WebElement login = driver.findElement(By.name("q"));
//            WebElement password = driver.findElement(By.name("p"));
//            login.sendKeys("ahmed");
//            password.sendKeys("password");
//            WebElement loginB = driver.findElement(By.name("button"));
//            loginB.click();
//
//
//            Thread.sleep(10000);
//        }catch (NoSuchElementException | InterruptedException e){
//            e.printStackTrace();
//        }
//        if(driver != null) driver.quit();
//    }
//}
