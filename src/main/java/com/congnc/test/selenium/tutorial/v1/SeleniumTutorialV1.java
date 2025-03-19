/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.congnc.test.selenium.tutorial.v1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.edge.EdgeOptions;

/**
 *
 * @author nccong
 */
public class SeleniumTutorialV1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        searchGG();
    }

    public static void searchGG() {
        ///1. Khai bao bien dai dien tro den trinh duyet se duoc mo/dc new
        WebDriver myBrowser; // ben obj thuoc bo thu vien Selenium
        //thang nay sex tro den trinh duyet khi dc new
        // moi lan new la mot lan trinh duyet mo ra, 1 vung ram dc cap 
        //1 obj trinh duyet duoc new trong HEAP

        //2. Khai bao nguoi em song sinh, ga se dieu khien trinh duyet
        //    no luon dc phat hanh song song voi phien ban trinh duyet dc public
        //    tuong thich voi version trinh duyet dang dung!! dieu nay la bat buoc
        //    WebDriver la ten goi cua nguoi anh em song sinh, la file .exe/.dll
        String driverPath = "msedgedriver.exe";

        //3. new Browser gan ket voi nguoi em song sinh
        System.setProperty("webdriver.edge.driver", driverPath);
        // bao voi may ao java rang co 1 thang .exe muon tham gia vao lst class ma JVM quan ly.
        // .exe .dll xa mot dong class dieu khien trinh duyet vao trong JVM luc run time
        // va goi nhom class nay la webdriver.edge.driver -> hang so quy uoc san
        // code Selenium qua class Webdriver , EdgeDriver o day
        // biet cach choi voi cac class cua .exe vua roi, vi chung dang cung o trong may ao

//        EdgeOptions opt = new EdgeOptions();
//        opt.addArguments("--inprivate");
//        myBrowser = new EdgeDriver(opt);
        myBrowser = new EdgeDriver();
        //4. viet code dung Selenium de noi chuyen voi Driver
        // Browser san sang thong qua Driver dua data cho minh (trang web trong ram)
        // cho minh duoi dang cay DOM - Document Obj Model
        // trang HTML tra ve trong RAM cua trinh duyet dc xem la 1 tree cac obj 
        // node/tag dc xem la 1 obj thuoc nhom WebElement

        myBrowser.get("https://www.youtube.com"); // duyet trang tren obj trinh duyet vua new
         myBrowser.manage().window().maximize();
        // ta se di tim cac  tag, va hanh xu tren cac the. Cac the nay la obj 
        // nam tron obj to cua my Browser 
        WebElement searchBox = myBrowser.findElement(By.name("search_query"));
        searchBox.sendKeys("Giáo làng");
        searchBox.submit();
       
    }

//    public static void searchGG(){
//        ///1. Khai bao bien dai dien tro den trinh duyet se duoc mo/dc new
//        WebDriver myBrowser; // ben obj thuoc bo thu vien Selenium
//          //thang nay sex tro den trinh duyet khi dc new
//          // moi lan new la mot lan trinh duyet mo ra, 1 vung ram dc cap 
//          //1 obj trinh duyet duoc new trong HEAP
//          
//          //2. Khai bao nguoi em song sinh, ga se dieu khien trinh duyet
//          //    no luon dc phat hanh song song voi phien ban trinh duyet dc public
//          //    tuong thich voi version trinh duyet dang dung!! dieu nay la bat buoc
//          //    WebDriver la ten goi cua nguoi anh em song sinh, la file .exe/.dll
//          String driverPath = "msedgedriver.exe";
//          
//          //3. new Browser gan ket voi nguoi em song sinh
//          System.setProperty("webdriver.edge.driver",driverPath);
//          // bao voi may ao java rang co 1 thang .exe muon tham gia vao lst class ma JVM quan ly.
//          // .exe .dll xa mot dong class dieu khien trinh duyet vao trong JVM luc run time
//          // va goi nhom class nay la webdriver.edge.driver -> hang so quy uoc san
//          // code Selenium qua class Webdriver , EdgeDriver o day
//          // biet cach choi voi cac class cua .exe vua roi, vi chung dang cung o trong may ao
//          myBrowser = new EdgeDriver();
//          //4. viet code dung Selenium de noi chuyen voi Driver
//          // Browser san sang thong qua Driver dua data cho minh (trang web trong ram)
//          // cho minh duoi dang cay DOM - Document Obj Model
//          // trang HTML tra ve trong RAM cua trinh duyet dc xem la 1 tree cac obj 
//          // node/tag dc xem la 1 obj thuoc nhom WebElement
//          
//          myBrowser.get("https://google.com"); // duyet trang tren obj trinh duyet vua new
//          myBrowser.manage().window().maximize();
//    }
}
