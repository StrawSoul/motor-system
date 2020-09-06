package com.motor.system.server.service;

import com.motor.common.message.command.Command;
import com.motor.common.paging.PageList;
import com.motor.system.server.command.SysMenuModify;
import com.motor.system.server.command.SysMenuSearch;
import com.motor.system.server.dictionary.SysDictionary;
import com.motor.system.server.menu.SysMenu;

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
public class SysDictionaryManagementService {
    public void create(Command<SysDictionary> cmd) {

    }

    public void remove(Command<String> cmd) {
    }

    public void modify(Command<SysMenuModify> cmd) {
    }

    public SysDictionary findById(Command<String> cmd) {
        return null;
    }

    public PageList<SysMenu> search(Command<SysMenuSearch> cmd) {
        return null;
    }
}
