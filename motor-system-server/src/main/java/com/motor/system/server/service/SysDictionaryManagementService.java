package com.motor.system.server.service;

import com.motor.common.domain.Repository;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.system.server.command.SysDictionarySearch;
import com.motor.system.server.dictionary.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
 * version: 0.0.0  2020/9/4 16:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
@Service
public class SysDictionaryManagementService {

    @Autowired
    private Repository<Integer,SysDictionary> sysDictionaryRepository;

    public void create(Command<SysDictionary> cmd) {
        SysDictionary sysDictionary = BeanMapperUtil.map(cmd.data(), SysDictionary.class);
        CommandToEntityUtils.forInsert(cmd, sysDictionary);
        sysDictionaryRepository.insert(sysDictionary);
    }

    public void remove(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        sysDictionaryRepository.delete(id);
    }

    public void modify(Command<SysDictionary> cmd) {
        SysDictionary SysDictionary = BeanMapperUtil.map(cmd.data(), SysDictionary.class);
        CommandToEntityUtils.forInsert(cmd, SysDictionary);
        sysDictionaryRepository.update(SysDictionary);
    }

    public SysDictionary findById(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        SysDictionary SysDictionary = sysDictionaryRepository.findById(id);
        return SysDictionary;
    }

    public PageList<SysDictionary> search(Command<SysDictionarySearch> cmd) {
        SysDictionarySearch search = cmd.data();
        PageList<SysDictionary> pageList = sysDictionaryRepository.search(search, search.toPaging());
        return pageList;
    }
}
