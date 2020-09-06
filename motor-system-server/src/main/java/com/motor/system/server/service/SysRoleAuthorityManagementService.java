package com.motor.system.server.service;

import com.motor.common.domain.Repository;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.system.server.authority.SysRoleAuthority;
import com.motor.system.server.command.SysRoleAuthoritySearch;
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
public class SysRoleAuthorityManagementService {
    @Autowired
    private Repository<Integer, SysRoleAuthority> sysRoleAuthorityRepository;

    public void create(Command<SysRoleAuthority> cmd) {
        SysRoleAuthority SysRoleAuthority = BeanMapperUtil.map(cmd.data(), SysRoleAuthority.class);
        CommandToEntityUtils.forInsert(cmd, SysRoleAuthority);
        sysRoleAuthorityRepository.insert(SysRoleAuthority);
    }

    public void remove(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        sysRoleAuthorityRepository.delete(id);
    }

    public void modify(Command<SysRoleAuthority> cmd) {
        SysRoleAuthority SysRoleAuthority = BeanMapperUtil.map(cmd.data(), SysRoleAuthority.class);
        CommandToEntityUtils.forInsert(cmd, SysRoleAuthority);
        sysRoleAuthorityRepository.update(SysRoleAuthority);
    }

    public SysRoleAuthority findById(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        SysRoleAuthority SysRoleAuthority = sysRoleAuthorityRepository.findById(id);
        return SysRoleAuthority;
    }

    public PageList<SysRoleAuthority> search(Command<SysRoleAuthoritySearch> cmd) {
        SysRoleAuthoritySearch search = cmd.data();
        PageList<SysRoleAuthority> pageList = sysRoleAuthorityRepository.search(search, search.toPaging());
        return pageList;
    }
}
