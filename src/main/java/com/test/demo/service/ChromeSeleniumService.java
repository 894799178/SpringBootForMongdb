package com.test.demo.service;

import com.test.demo.model.DamageBean;
import org.openqa.selenium.WebDriver;

public interface ChromeSeleniumService {
    /**
     * 获取google浏览器的WebDriver实例
     * @return
     */
    WebDriver getInstance();

    /**
     * 获取伤害数据.
     * @param instance
     * @return
     */
    String getDamegeDataBeans(WebDriver instance);
}
