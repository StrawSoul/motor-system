package com.motor.system.server.dictionary;

import com.motor.common.dsl.handler.PersistentDSLBuilders;
import com.motor.common.spring.repository.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * ===========================================================================================
 * 设计说明
 * -------------------------------------------------------------------------------------------
 * <p>
 * ===========================================================================================
 * 方法简介
 * -------------------------------------------------------------------------------------------
 * {methodName}     ->  {description}
 * ===========================================================================================
 * 变更记录
 * -------------------------------------------------------------------------------------------
 * version: 0.0.0  2020/9/4 14:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
@Service
public class SysDictionaryRepository extends SimpleRepository<Integer, SysDictionary> {
    @Autowired
    public SysDictionaryRepository( JdbcTemplate jdbcTemplate, PersistentDSLBuilders persistentDSLBuilders) {
        super("sys_dictionary", SysDictionary.class, jdbcTemplate, persistentDSLBuilders);
    }
}
