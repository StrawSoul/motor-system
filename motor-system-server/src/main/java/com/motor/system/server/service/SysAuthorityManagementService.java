package com.motor.system.server.service;

import com.motor.common.domain.Repository;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.system.server.authority.SysAuthority;
import com.motor.system.server.command.SysAuthoritySearch;
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
public class SysAuthorityManagementService {
    @Autowired
    private Repository<Integer, SysAuthority> sysAuthorityRepository;

    public void create(Command<SysAuthority> cmd) {
        SysAuthority SysAuthority = BeanMapperUtil.map(cmd.data(), SysAuthority.class);
        CommandToEntityUtils.forInsert(cmd, SysAuthority);
        sysAuthorityRepository.insert(SysAuthority);
    }

    public void remove(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        sysAuthorityRepository.delete(id);
    }

    public void modify(Command<SysAuthority> cmd) {
        SysAuthority SysAuthority = BeanMapperUtil.map(cmd.data(), SysAuthority.class);
        CommandToEntityUtils.forInsert(cmd, SysAuthority);
        sysAuthorityRepository.update(SysAuthority);
    }

    public SysAuthority findById(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        SysAuthority SysAuthority = sysAuthorityRepository.findById(id);
        return SysAuthority;
    }

    public PageList<SysAuthority> search(Command<SysAuthoritySearch> cmd) {
        SysAuthoritySearch search = cmd.data();
        PageList<SysAuthority> pageList = sysAuthorityRepository.search(search, search.toPaging());
        return pageList;
    }
}
