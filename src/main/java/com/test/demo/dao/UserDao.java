package com.test.demo.dao;

import com.test.demo.model.UserEntity;

public interface UserDao {
    /**
     * 保存用户数据
     * @param user
     */
    void saveUser(UserEntity user);

    /**
     * 根据用户名字查找用户
     * @param userName
     * @return
     */
    UserEntity findUserByUserName(String userName);

    /**
     * 更新对象
     * @param user
     */
    void updateUser(UserEntity user);

    /**
     * 删除对象
     * @param id
     */
    void deleteUserById(Long id);
}
