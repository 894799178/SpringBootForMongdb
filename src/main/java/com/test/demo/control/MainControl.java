package com.test.demo.control;


import com.test.demo.model.DamageData;
import com.test.demo.service.ChromeSeleniumService;
import com.test.demo.service.DamageService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MainControl {

    @Resource
    ChromeSeleniumService chromeSeleniumService;

    @Resource
    DamageService damageService;

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
    @PostMapping(value = "/updateData")
    @ResponseBody
    public void updateData(@RequestBody  List<DamageData> datas){
        damageService.batchInsert(datas);
    }

    @RequestMapping(value="/getDamageDataByTypeId")
    @ResponseBody
    public List<DamageData> getDamageDataByTypeId(String typeId){
        System.out.println("getDamageDataByTypeId-->"+typeId);
        List<DamageData> list =  damageService.getDamageDataByTypeId(typeId);

        for (DamageData dd:list) {
            System.out.println("控制层->"+dd);
        }
        return list;
    }

    @RequestMapping("/damageShow")
    public String damageShow(){
        System.out.println("进入控制层");
        return "pages/analyse/damageShow.html";
    }






}
