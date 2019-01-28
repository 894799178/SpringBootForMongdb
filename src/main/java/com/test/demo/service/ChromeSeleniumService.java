package com.test.demo.service;

import org.openqa.selenium.WebDriver;

/**
 * 自动化谷歌浏览器服务层
 */
public interface ChromeSeleniumService {
    /**
     * 获取google浏览器的WebDriver实例
     * @return
     */
    WebDriver getInstance();

    /**
     * 获取伤害数据.
     * @return
     */
    String getDamegeDataBeans();

    /**
     * 获取自动化消息
     * @return
     */
    String getAutoMessage();
}
