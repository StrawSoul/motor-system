package com.motor.system.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.message.http.servlet.HttpServletCommandBuilder;
import com.motor.system.server.authority.SysRoleAuthority;
import com.motor.system.server.command.SysRoleAuthoritySearch;
import com.motor.system.server.service.SysRoleAuthorityManagementService;
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
@RequestMapping("management/system/role-authority")
public class SysRoleAuthorityManagementController {
    @Autowired
    SysRoleAuthorityManagementService sysRoleAuthorityService;

    @PostMapping
    public ResultData create(@RequestBody SysRoleAuthority SysRoleAuthorityCreate){
        Command<SysRoleAuthority> cmd = HttpServletCommandBuilder.get()
                .data(SysRoleAuthorityCreate)
                .build();
        sysRoleAuthorityService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        sysRoleAuthorityService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable Integer id, @RequestBody SysRoleAuthority SysRoleAuthorityModify){
        SysRoleAuthorityModify.setId(id);
        Command<SysRoleAuthority> cmd = HttpServletCommandBuilder.get()
                .data(SysRoleAuthorityModify)
                .build();
        sysRoleAuthorityService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysRoleAuthority menu = sysRoleAuthorityService.findById(cmd);
        return ResultBuilder.getInstance()
                .data(menu)
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<SysRoleAuthority>> search( SysRoleAuthoritySearch SysRoleAuthoritySearch){
        Command<SysRoleAuthoritySearch> cmd = HttpServletCommandBuilder.get()
                .data(SysRoleAuthoritySearch)
                .build();
        PageList<SysRoleAuthority> pageList = sysRoleAuthorityService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
