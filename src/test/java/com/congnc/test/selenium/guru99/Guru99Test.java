/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.congnc.test.selenium.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 *
 * @author nccong
 */
public class Guru99Test {

    private static WebDriver myBrowser;
    private static String driverPath = "msedgedriver.exe";

    public Guru99Test() {
    }

    @BeforeAll
    public static void setUpClass() {
        // chuan bi value cho cac bien, khoi dong trinh duyet
        System.setProperty("webdriver.edge.driver", driverPath);
        myBrowser = new EdgeDriver(); // dung them class EdgeOption de them mot vai che do

        myBrowser.manage().window().maximize();
    }

    @Test
    public void tesstLoginGivenRightAccountSayHelloUserName() throws InterruptedException {
        String userName = "mngr616749";
        String password = "yjEhEsE";
        myBrowser.get("https://demo.guru99.com/V4/");
        //Tim the username, password qua: CSS selector, Jquery, Xpath, name, id, class
        // chính là một dạng câu query/SQL, app dụng cho tìm data thẻ phía sau trình duyệt
        //xPath. CSS Selector ~ SQL
        //browser ~ DB
        // Đưa câu query xPath cho myBrowser, tìm thẻ giúp tôi F12, Ctrl F
        // nếu tìm thấy thẻ, thì đó là 1 obj được trả về thuộc dạng class WebElement
        WebElement userTag = myBrowser.findElement(By.xpath("(//input[@name='uid'])[1]"));
        userTag.sendKeys(userName); // gõ vào text nếu thẻ tìm thấy
        WebElement passTag = myBrowser.findElement(By.xpath("(//input[@name='password'])[1]"));
        passTag.sendKeys(password);
        WebElement btnLogin = myBrowser.findElement(By.xpath("(//input[@name='btnLogin'])[1]"));
        btnLogin.click();

        WebElement helloTag = myBrowser.findElement(By.xpath("(//td[normalize-space()='Manger Id : mngr616749'])[1]"));

        String actualHelloMsg = helloTag.getText();
        System.out.println("Hello MSG after login successfully: " + helloTag.getText());
        assertEquals("Manger Id : "+userName, actualHelloMsg);
        Thread.sleep(5000); // cần chờ load trang sau khi login , tránh trường hợp bất đồng bộ giữa web và code test.
    }

    @AfterAll
    public static void tearDownClass() throws InterruptedException {
        WebElement btnLogout = myBrowser.findElement(By.xpath("(//a[normalize-space()='Log out'])[1]"));
        btnLogout.click();
        Thread.sleep(10000);
        myBrowser.quit();// clean trash , undo khi @test da chay, da lam thay diu hien trang
        //nao do, vd DB co rac do chat test CRUD

    }

}
