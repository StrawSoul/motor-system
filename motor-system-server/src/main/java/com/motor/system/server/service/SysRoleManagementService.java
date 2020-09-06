package com.motor.system.server.service;

import com.motor.common.domain.PrimaryKeyProducer;
import com.motor.common.domain.Repository;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.system.server.authority.SysRole;
import com.motor.system.server.command.SysRoleSearch;
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
public class SysRoleManagementService {
    @Autowired
    private Repository<Integer, SysRole> sysRoleRepository;

    public void create(Command<SysRole> cmd) {
        SysRole SysRole = BeanMapperUtil.map(cmd.data(), SysRole.class);
        CommandToEntityUtils.forInsert(cmd, SysRole);
        sysRoleRepository.insert(SysRole);
    }

    public void remove(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        sysRoleRepository.delete(id);
    }

    public void modify(Command<SysRole> cmd) {
        SysRole SysRole = BeanMapperUtil.map(cmd.data(), SysRole.class);
        CommandToEntityUtils.forInsert(cmd, SysRole);
        sysRoleRepository.update(SysRole);
    }

    public SysRole findById(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        SysRole SysRole = sysRoleRepository.findById(id);
        return SysRole;
    }

    public PageList<SysRole> search(Command<SysRoleSearch> cmd) {
        SysRoleSearch search = cmd.data();
        PageList<SysRole> pageList = sysRoleRepository.search(search, search.toPaging());
        return pageList;
    }
}
