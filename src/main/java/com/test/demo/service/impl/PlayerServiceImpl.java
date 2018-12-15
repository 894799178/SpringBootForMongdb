package com.test.demo.service.impl;

import com.test.demo.dao.PlayerDao;
import com.test.demo.model.Player;
import com.test.demo.service.PlayerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Resource
    PlayerDao playerDao;

    @Override
    public void deleteQLCAccount() {
        System.out.println("进入服务层");
        //匹配所有 帐号中有qlc字符对象
        List<Player> players = playerDao.findPlayerByReg("mac", "qlc");
        for (Player player:players) {
            System.out.println(player);
        }
    }
}
