package com.test;

import com.mongodb.util.JSON;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Iterator;
import java.util.logging.Level;

public class testCho {



    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Tester\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        //设置Webdriver启动chrome为默认用户的配置信息（包括书签、扩展程序等）
        ChromeOptions options = new ChromeOptions();
        //为了获取console的日志输出
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.INFO);//输入为info的日志 
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        //传入谷歌启动器中
        WebDriver driver = new ChromeDriver(caps);
        driver.manage().window().maximize();//窗口最大化
        driver.get("http://localhost:7456");//打开测试地址
        LogEntries logEntries =driver.manage().logs().get(LogType.BROWSER);
       while( (driver.manage().logs().get(LogType.BROWSER)!=null)){
           logEntries =driver.manage().logs().get(LogType.BROWSER);
           for(LogEntry entry : logEntries) {
               System.out.println("chrome.console===="+" "+entry.getMessage());
           }
       }

//        System.setProperty("webdriver.chrome.driver","C:\\Users\\Tester\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        LoggingPreferences logPrefs = new LoggingPreferences();
//        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//        options.addArguments("headless");
//        //禁用沙盒nage
//        options.addArguments("no-sandbox");
//        options.addArguments("disable-gpu");
//        cap.setCapability(ChromeOptions.CAPABILITY, options);
//        ChromeDriver driver = new ChromeDriver(cap);
//        driver.get("https://www.baidu.com");
//        String currentURL = driver.getCurrentUrl();
//        LogEntries logs = driver.manage().logs().get("performance");
//        int status = -1;
//        System.out.println("\nList of log entries:\n");
//        for (Iterator<LogEntry> it = logs.iterator(); it.hasNext(); ) {
//            LogEntry entry = it.next();
//         //   try {
//
//
//            //    JSONObject json = JSON.parseObject(entry.getMessage());
//                System.out.println(entry.getMessage());
////                JSONObject message = json.getJSONObject("message");
////                String method = message.getString("method");
////                if (method != null&& "Network.responseReceived".equals(method)) {
////                    JSONObject params = message.getJSONObject("params");
////                    JSONObject response = params.getJSONObject("response");
////                    String messageUrl = response.getString("url");
////                    if (currentURL.equals(messageUrl)) {
////                        status = response.getInteger("status");
////                        System.out.println("---------- bingo !!!!!!!!!!!!!! returned response for "+ messageUrl + ": " + status);
////                        System.out.println("---------- bingo !!!!!!!!!!!!!! headers: "+ response.get("headers"));
////                    }
////                }
////            } catch (JSONException e) {
////                // TODO Auto-generated catch block
////                e.printStackTrace();
////            }
//        }
// //       System.out.println("\nstatus code: " + status);

    }
}
