package com.test.demo.service.impl;

import com.test.demo.mapper.DamageDataMapper;
import com.test.demo.model.DamageData;
import com.test.demo.service.DamageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DamageServiceImpl implements DamageService {

    @Resource
    DamageDataMapper damageDataMapper;

    @Override
    public void batchInsert(List<DamageData> datas) {
        //插入数据前,先把旧数据删除
        damageDataMapper.deleteByTypeId(datas.get(0).getTypeId());
        damageDataMapper.insertBatch(datas);
    }

    @Override
    public List<DamageData> getDamageDataByTypeId(String typeId) {
        return damageDataMapper.selectByTypeId(typeId);
    }


}
