package com.test.demo.control;


import com.test.demo.model.DamageData;
import com.test.demo.service.ChromeSeleniumService;
import com.test.demo.service.DamageService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MainControl {

    @Resource
    ChromeSeleniumService chromeSeleniumService;

    @Resource
    DamageService damageService;

    @RequestMapping("/")
    public String index(){
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
    public String getDamageData(){
        String damageData = chromeSeleniumService.getDamegeDataBeans();
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
        List<DamageData> list =  damageService.getDamageDataByTypeId(typeId);
        for (DamageData dd:list) {
            System.out.println(dd);
        }
        return list;
    }

    @RequestMapping("/damageShow")
    public String damageShow(){
        return "pages/analyse/damageShow.html";
    }

    @RequestMapping("/damageTest")
    public String damageTest(){
        return "pages/analyse/damageTest.html";
    }

    @RequestMapping("/getAutoMessage")
    @ResponseBody
    public String getAutoMessage(){
        return chromeSeleniumService.getAutoMessage();
    }

//    @RequestMapping("/getInstance")
//    @ResponseBody
//    public String getInstance(){
//        chromeSeleniumService.getInstance();
//        return "200";
//    }

}
