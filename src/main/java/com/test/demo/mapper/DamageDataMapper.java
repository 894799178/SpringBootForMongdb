package com.test.demo.mapper;

import com.test.demo.model.DamageData;

import java.util.List;

public interface DamageDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DamageData record);

    int insertSelective(DamageData record);

    DamageData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DamageData record);

    int updateByPrimaryKey(DamageData record);

    void insertBatch(List<DamageData> damageData);

    /**
     * 按照typeId 获取一组伤害数据
     * @param typeId
     * @return
     */
    List<DamageData> selectByTypeId(String typeId);

    /**
     * 根据一个typeId 删除一组数据
     * @param typeId
     */
    void deleteByTypeId(String typeId);

}