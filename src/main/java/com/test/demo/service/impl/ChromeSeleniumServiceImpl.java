package com.test.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.test.demo.enums.EnumLoggingToken;
import com.test.demo.model.AutoClickModel;
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

    private static WebDriver webDriver= null;

    @Resource
    public DataProcessService dataProcessService;

    @Override
    public synchronized WebDriver getInstance() {
            if (webDriver == null){
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
        return  this.webDriver;
    }

    @Override
    public synchronized String getDamegeDataBeans() {
        String flag =  EnumLoggingToken.DAMAGE_TEST.getValue();
        return  this.messageDispose(flag,DamageBean.class);
    }

    @Override
    public String getAutoMessage() {
        String flag = EnumLoggingToken.AUTO_CLICK_FLAG.getValue();
        return this.messageDispose(flag, AutoClickModel.class);
    }

    /**
     * 处理来自谷歌浏览器中的消息并转化成String数据
     * @param flag
     * @param clazz
     * @return
     */
    private <T> String messageDispose (String flag,Class<T> clazz){
        LogEntries logEntries =this.getInstance().manage().logs().get(LogType.BROWSER);
        List<T> modelList = new ArrayList<>();
        //迭代监控到的日志,获取控制台所有日志
        for(LogEntry entry : logEntries) {
            System.out.println(entry.getMessage());
            T model =  dataProcessService.stringToDamageBean(entry.getMessage(),flag,clazz);
            if(model!= null){
                modelList.add(model);
            }
        }
        String temp = null;
        if(modelList.size()>0){
            temp = JSON.toJSONString(modelList);
        }
        return temp;
    }


}
