package com.test.demo.dao.impl;

import com.test.demo.dao.PlayerDao;
import com.test.demo.dao.UserDao;
import com.test.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Player findUserByUserName(String playerName) {
        Query query = new Query(Criteria.where("name").in(playerName));
        Player player = mongoTemplate.findOne(query,Player.class,"player");
        return player;
    }

    @Override
    public void save(Player player) {
        mongoTemplate.save(player);
    }

    @Override
    public Player findUserById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Player player = mongoTemplate.findOne(query,Player.class,"player");
        return player;
    }

    @Override
    public List<Player> findPlayerByReg(String param, String reg) {
        Query query = new Query(Criteria.where(param).regex(reg));
        List<Player> players = mongoTemplate.find(query, Player.class, "player");
        return players;
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query,Player.class,"player");
    }


}
