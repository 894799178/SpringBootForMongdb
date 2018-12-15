package com.test;

import com.test.demo.dao.PlayerDao;
import com.test.demo.dao.UserDao;
import com.test.demo.model.Player;
import com.test.demo.model.UserEntity;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Resource
    private PlayerDao playerDao;
    @Test
    public void testSaveUser(){
        UserEntity user = new UserEntity();
        user.setId(21L);
        user.setUserName("小明");
        user.setPassWord("23333");
        userDao.saveUser(user);
        System.out.println("233");
    }
    @Test
    public void testSavePlayer(){
        Player user = new Player();
        user.setId(4L);
        user.setMac("test233");
        user.setName("name?");
        playerDao.save(user);
        System.out.println("2333");
    }

    @Test
    public void testSelectUser(){
        UserEntity userByUserName = userDao.findUserByUserName("小明");
        System.out.println(userByUserName);
    }


    @Test
    public void testSelectPrayer(){
        Player debug_qlc1234 = playerDao.findUserByUserName("高俊楚");
        System.out.println(debug_qlc1234);
    }
    @Test
    public void testDeletePlayer(){
        playerDao.deleteById("2");
    }


}
