package com.motor.system.server.service;

import com.motor.common.domain.Repository;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.system.server.command.SysMenuSearch;
import com.motor.system.server.menu.SysMenu;
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
public class SysMenuManagementService {
    @Autowired
    private Repository<Integer, SysMenu> sysMenuRepository;

    public void create(Command<SysMenu> cmd) {
        SysMenu SysMenu = BeanMapperUtil.map(cmd.data(), SysMenu.class);
        CommandToEntityUtils.forInsert(cmd, SysMenu);
        sysMenuRepository.insert(SysMenu);
    }

    public void remove(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        sysMenuRepository.delete(id);
    }

    public void modify(Command<SysMenu> cmd) {
        SysMenu SysMenu = BeanMapperUtil.map(cmd.data(), SysMenu.class);
        CommandToEntityUtils.forInsert(cmd, SysMenu);
        sysMenuRepository.update(SysMenu);
    }

    public SysMenu findById(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        SysMenu SysMenu = sysMenuRepository.findById(id);
        return SysMenu;
    }

    public PageList<SysMenu> search(Command<SysMenuSearch> cmd) {
        SysMenuSearch search = cmd.data();
        PageList<SysMenu> pageList = sysMenuRepository.search(search, search.toPaging());
        return pageList;
    }
}
