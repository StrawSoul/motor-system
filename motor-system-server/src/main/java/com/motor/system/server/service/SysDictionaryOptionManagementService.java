package com.motor.system.server.service;

import com.motor.common.domain.Repository;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.system.server.command.SysDictionaryOptionSearch;
import com.motor.system.server.dictionary.SysDictionaryOption;
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
public class SysDictionaryOptionManagementService {
    @Autowired
    private Repository<Integer,SysDictionaryOption> sysDictionaryOptionRepository;

    public void create(Command<SysDictionaryOption> cmd) {
        SysDictionaryOption SysDictionaryOption = BeanMapperUtil.map(cmd.data(), SysDictionaryOption.class);
        CommandToEntityUtils.forInsert(cmd, SysDictionaryOption);
        sysDictionaryOptionRepository.insert(SysDictionaryOption);
    }

    public void remove(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        sysDictionaryOptionRepository.delete(id);
    }

    public void modify(Command<SysDictionaryOption> cmd) {
        SysDictionaryOption SysDictionaryOption = BeanMapperUtil.map(cmd.data(), SysDictionaryOption.class);
        CommandToEntityUtils.forInsert(cmd, SysDictionaryOption);
        sysDictionaryOptionRepository.update(SysDictionaryOption);
    }

    public SysDictionaryOption findById(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        SysDictionaryOption SysDictionaryOption = sysDictionaryOptionRepository.findById(id);
        return SysDictionaryOption;
    }

    public PageList<SysDictionaryOption> search(Command<SysDictionaryOptionSearch> cmd) {
        SysDictionaryOptionSearch search = cmd.data();
        PageList<SysDictionaryOption> pageList = sysDictionaryOptionRepository.search(search, search.toPaging());
        return pageList;
    }
}
