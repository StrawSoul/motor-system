package com.motor.system.server.service;

import com.motor.common.domain.Repository;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.system.server.command.SysLinkSearch;
import com.motor.system.server.link.SysLink;
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
public class SysLinkManagementService {
    @Autowired
    private Repository<Integer, SysLink> sysLinkRepository;

    public void create(Command<SysLink> cmd) {
        SysLink SysLink = BeanMapperUtil.map(cmd.data(), SysLink.class);
        CommandToEntityUtils.forInsert(cmd, SysLink);
        sysLinkRepository.insert(SysLink);
    }

    public void remove(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        sysLinkRepository.delete(id);
    }

    public void modify(Command<SysLink> cmd) {
        SysLink SysLink = BeanMapperUtil.map(cmd.data(), SysLink.class);
        CommandToEntityUtils.forInsert(cmd, SysLink);
        sysLinkRepository.update(SysLink);
    }

    public SysLink findById(Command<Integer> cmd) {
        Integer id = Optional.of(cmd.data()).get();
        SysLink SysLink = sysLinkRepository.findById(id);
        return SysLink;
    }

    public PageList<SysLink> search(Command<SysLinkSearch> cmd) {
        SysLinkSearch search = cmd.data();
        PageList<SysLink> pageList = sysLinkRepository.search(search, search.toPaging());
        return pageList;
    }
}
