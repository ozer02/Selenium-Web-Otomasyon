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
            //
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
            //N11 Anasayfası Açılır
            driver.get(homePage);
            Thread.sleep(1000);
            //Giriş Yap Butonuna basar
            driver.findElement(By.className("btnSignIn")).click();
            Thread.sleep(1000);
            //Kullanıcı Adı Şifre Girilir ve Giriş Yapar
            driver.findElement(By.name("email")).sendKeys("selenium.deneme@gmail.com");
            driver.findElement(By.name("password")).sendKeys("testinium02");
            Thread.sleep(1000);
            driver.findElement(By.id("loginButton")).click();
            Thread.sleep(1000);
            //Arama kutucuğuna bilgisayar kelimesi girilir ve arama yapılır
            driver.findElement(By.id("searchData")).sendKeys("bilgisayar");
            Thread.sleep(1000);
            driver.findElement(By.className("searchBtn")).click();
            Thread.sleep(1000);
            //Arama sonuçları sayfasından 2.sayfa açılır
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/a[2]")).click();
            Thread.sleep(1000);
            //Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/section[1]/div[2]/ul[1]/li["+i+"]/div[1]/div[1]/a[1]")).click();
            Thread.sleep(1000);
            //Seçilen Ürün Sepete Eklenir
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[3]/div[3]/a[2]")).click();
            Thread.sleep(1000);
            //Sepet Açılır
            driver.findElement(By.className("myBasket")).click();
            Thread.sleep(1000);
            //Adet arttırılarak ürün adedi 2 olur
            driver.findElement(By.xpath("//*[@class='spinnerFieldContainer']/span[1]")).click();
            Thread.sleep(1000);
            //Ürün Sepetten Silinir
            driver.findElement(By.xpath("//*[@class='prodAction']/span[1]")).click();
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @After
    public void tearDown() throws Exception {

    }

}
