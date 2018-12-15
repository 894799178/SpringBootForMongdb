package com.test.demo.dao;

import com.test.demo.model.Player;

import java.util.List;

public interface PlayerDao {

    Player findUserByUserName(String playerName);

    void save(Player player);

    /**
     * 查找用户通过Id
     * @param id
     * @return
     */
    Player findUserById(String id);

    /**
     * 通过正则表达式获得数据组
     * @param param 表达式所要匹配的字段
     * @param reg 表达式
     * @return
     */
    List<Player> findPlayerByReg(String param,String reg);

    /**
     * 根据Id删除player
      * @param id
     */
    void deleteById(String id);

}
