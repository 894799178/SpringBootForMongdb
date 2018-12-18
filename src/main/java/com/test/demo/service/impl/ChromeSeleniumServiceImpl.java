package com.test.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.test.demo.Utils.StringUtils;
import com.test.demo.model.DamageBean;
import com.test.demo.service.ChromeSeleniumService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
@Service
public class ChromeSeleniumServiceImpl implements ChromeSeleniumService {

    public static WebDriver webDriver = null;

    @Override
    public synchronized WebDriver getInstance() {
        if(webDriver == null){
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
            this.webDriver = driver;
        }
        return webDriver;
    }

    @Override
    public synchronized String getDamegeDataBeans(WebDriver instance) {
        LogEntries logEntries =instance.manage().logs().get(LogType.BROWSER);
        List<DamageBean> damageBeanList = new ArrayList<>();
        for(LogEntry entry : logEntries) {
            System.out.println(entry.getMessage());
            DamageBean damageBean =  stringToDamageBean(entry.getMessage(),"shcs");
            if(damageBean!= null){
                damageBeanList.add(damageBean);
            }
        }
        String temp = null;
        if(damageBeanList.size()>0){
             temp = (String) JSON.toJSONString(damageBeanList);
        }
        return temp;
    }

    /**
     * 过滤字符串如果存在造成伤害则,填充对象并返回.
     * @param string
     * @param flag 按照标记字符串进行过滤字符串
     * @return
     */
    private  DamageBean stringToDamageBean(String string,String flag){
        int exist = StringUtils.isExist(string, flag);
        DamageBean damageBean = null;
        //StringBuilder sb  = new StringBuilder(string);
        if(exist> 0){
           int index = string.indexOf("\"");
            //String   substring = string.substring(0,string.length()-1).replace("\\","");
            String  substring = string.substring(index+1,string.length()-1).replace("\\","");
           System.out.println(substring);
            System.out.println("substring->"+substring);
            damageBean = JSON.parseObject(substring,DamageBean.class);
        }
        return damageBean;
    }

}
