package com.motor.system.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.message.http.servlet.HttpServletCommandBuilder;
import com.motor.system.server.command.SysMenuSearch;
import com.motor.system.server.menu.SysMenu;
import com.motor.system.server.command.SysMenuCreate;
import com.motor.system.server.command.SysMenuModify;
import com.motor.system.server.service.SysMenuManagementService;
import org.springframework.web.bind.annotation.*;

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
 * version: 0.0.0  2020/9/1 09:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
@RestController
@RequestMapping("management/iot/entity")
public class SysMenuManagementController {

    SysMenuManagementService sysMenuService;

    @PostMapping
    public ResultData create(@RequestBody SysMenuCreate SysMenuCreate){
        Command<SysMenuCreate> cmd = HttpServletCommandBuilder.get()
                .data(SysMenuCreate)
                .build();
        sysMenuService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        sysMenuService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable Integer id, @RequestBody SysMenuModify SysMenuModify){
        SysMenuModify.setId(id);
        Command<SysMenuModify> cmd = HttpServletCommandBuilder.get()
                .data(SysMenuModify)
                .build();
        sysMenuService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysMenu menu = sysMenuService.findById(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<SysMenu>> search(@RequestBody SysMenuSearch SysMenuSearch){
        Command<SysMenuSearch> cmd = HttpServletCommandBuilder.get()
                .data(SysMenuSearch)
                .build();
        PageList<SysMenu> pageList = sysMenuService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
