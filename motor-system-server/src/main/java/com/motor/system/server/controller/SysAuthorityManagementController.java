package com.motor.system.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.message.http.servlet.HttpServletCommandBuilder;
import com.motor.system.server.authority.SysAuthority;
import com.motor.system.server.command.SysAuthoritySearch;
import com.motor.system.server.service.SysAuthorityManagementService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("management/system/authority")
public class SysAuthorityManagementController {

    @Autowired
    SysAuthorityManagementService sysAuthorityService;

    @PostMapping
    public ResultData create(@RequestBody SysAuthority SysAuthorityCreate){
        Command<SysAuthority> cmd = HttpServletCommandBuilder.get()
                .data(SysAuthorityCreate)
                .build();
        sysAuthorityService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        sysAuthorityService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable Integer id, @RequestBody SysAuthority SysAuthorityModify){
        SysAuthorityModify.setId(id);
        Command<SysAuthority> cmd = HttpServletCommandBuilder.get()
                .data(SysAuthorityModify)
                .build();
        sysAuthorityService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysAuthority menu = sysAuthorityService.findById(cmd);
        return ResultBuilder.getInstance()
                .data(menu)
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<SysAuthority>> search(SysAuthoritySearch SysAuthoritySearch){
        Command<SysAuthoritySearch> cmd = HttpServletCommandBuilder.get()
                .data(SysAuthoritySearch)
                .build();
        PageList<SysAuthority> pageList = sysAuthorityService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
