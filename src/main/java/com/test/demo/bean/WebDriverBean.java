package com.test.demo.bean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

import static com.test.demo.service.impl.ChromeSeleniumServiceImpl.webDriver;

@Component
public class WebDriverBean {

    @Bean
    public WebDriver getInstance(){
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
        return driver;
    }



}
