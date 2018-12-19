package com.test.demo.service;

import com.test.demo.model.DamageData;

import java.util.List;

public interface DamageService {

    void batchInsert(List<DamageData> datas);

    List<DamageData> getDamageDataByTypeId(String typeId);

}
