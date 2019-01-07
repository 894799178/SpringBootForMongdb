package com.test.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.test.demo.Utils.StringUtils;
import com.test.demo.enums.EnumLoggingToken;
import com.test.demo.model.DamageBean;
import com.test.demo.service.ChromeSeleniumService;
import com.test.demo.service.DataProcessService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
@Service
public class ChromeSeleniumServiceImpl implements ChromeSeleniumService {

    public static WebDriver webDriver = null;

    @Resource
    public DataProcessService dataProcessService;


    @Override
    public synchronized WebDriver getInstance() {
        if(webDriver == null){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Tester\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            //设置Webdriver启动chrome为默认用户的配置信息（包括书签、扩展程序等）
            ChromeOptions options = new ChromeOptions();
            //为了获取console的日志输出
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            LoggingPreferences logPrefs = new LoggingPreferences();
            //输入为info的日志 
            logPrefs.enable(LogType.BROWSER, Level.INFO);
            caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            //传入谷歌启动器中
            WebDriver driver = new ChromeDriver(caps);
            //窗口最大化
            driver.manage().window().maximize();
            //打开测试地址
            driver.get("http://localhost:7456");
            this.webDriver = driver;
        }
        return webDriver;
    }

    @Override
    public synchronized String getDamegeDataBeans(WebDriver instance) {
        LogEntries logEntries =instance.manage().logs().get(LogType.BROWSER);
        List<DamageBean> damageBeanList = new ArrayList<>();
        //迭代监控到的日志,获取控制台所有日志
        for(LogEntry entry : logEntries) {
            System.out.println(entry.getMessage());
            String shch = EnumLoggingToken.SHCS.getValue();
            DamageBean damageBean =  dataProcessService.stringToDamageBean(entry.getMessage(),shch,DamageBean.class);
            if(damageBean!= null){
                damageBeanList.add(damageBean);
            }
        }
        String temp = null;
        if(damageBeanList.size()>0){
             temp = JSON.toJSONString(damageBeanList);
        }
        return temp;
    }



}
