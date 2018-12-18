package com.test.demo.control;


import com.test.demo.model.DamageBean;
import com.test.demo.service.ChromeSeleniumService;
import com.test.demo.service.PlayerService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class MainControl {

    @Resource
    ChromeSeleniumService chromeSeleniumService;

    @RequestMapping("/")
    public String test(){
        System.out.println("进入控制层");
        WebDriver instance = chromeSeleniumService.getInstance();
        LogEntries logEntries =instance.manage().logs().get(LogType.BROWSER);
        for(LogEntry entry : logEntries) {
            System.out.println("chrome.console===="+" "+entry.getMessage());
        }
        return "index.html";
    }
    @RequestMapping("/getDamegeData")
    @ResponseBody
    public String getDamegeData(){
        WebDriver instance = chromeSeleniumService.getInstance();
        String damageData = chromeSeleniumService.getDamegeDataBeans(instance);
       System.out.println("控制层:"+damageData);
        return damageData;
    }








}
