package com.motor.system.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.message.http.servlet.HttpServletCommandBuilder;
import com.motor.system.server.authority.SysRole;
import com.motor.system.server.command.SysRoleSearch;
import com.motor.system.server.service.SysRoleManagementService;
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
@RequestMapping("management/system/role")
public class SysRoleManagementController {
    @Autowired
    SysRoleManagementService SysRoleService;

    @PostMapping
    public ResultData create(@RequestBody SysRole SysRoleCreate){
        Command<SysRole> cmd = HttpServletCommandBuilder.get()
                .data(SysRoleCreate)
                .build();
        SysRoleService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysRoleService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable Integer id, @RequestBody SysRole SysRoleModify){
        SysRoleModify.setId(id);
        Command<SysRole> cmd = HttpServletCommandBuilder.get()
                .data(SysRoleModify)
                .build();
        SysRoleService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysRole menu = SysRoleService.findById(cmd);
        return ResultBuilder.getInstance()
                .data(menu)
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<SysRole>> search(SysRoleSearch SysRoleSearch){
        Command<SysRoleSearch> cmd = HttpServletCommandBuilder.get()
                .data(SysRoleSearch)
                .build();
        PageList<SysRole> pageList = SysRoleService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
