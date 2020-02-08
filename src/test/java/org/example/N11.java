package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class N11 {

    protected WebDriver driver;
    public static String homePage = "https://www.n11.com/";

    @Before
    public void setUp() {

        try {

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ÖZER\\IdeaProjects\\Deneme\\Driver\\chromedriver.exe");
            driver = new ChromeDriver(capabilities);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            //dynamic wait
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test

    public void Login() {
        Random r = new Random();
        Integer i=r.nextInt(27);
        i+=1;
        try {

            driver.get(homePage);
            Thread.sleep(1000);
            driver.findElement(By.className("btnSignIn")).click();
            Thread.sleep(1000);
            driver.findElement(By.name("email")).sendKeys("m_ozer_02@hotmail.com");
            driver.findElement(By.name("password")).sendKeys("muhammed02300");
            Thread.sleep(1000);
            driver.findElement(By.id("loginButton")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("searchData")).sendKeys("bilgisayar");
            Thread.sleep(1000);
            driver.findElement(By.className("searchBtn")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/a[2]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/section[1]/div[2]/ul[1]/li["+i+"]/div[1]/div[1]/a[1]")).click();
            Thread.sleep(1000);




        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() throws Exception {

    }

}
