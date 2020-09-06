package com.motor.system.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.message.http.servlet.HttpServletCommandBuilder;
import com.motor.system.server.command.SysLinkSearch;
import com.motor.system.server.link.SysLink;
import com.motor.system.server.service.SysLinkManagementService;
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
@RequestMapping("management/system/dictionary/link")
public class SysLinkManagementController {
    @Autowired
    SysLinkManagementService SysLinkService;

    @PostMapping
    public ResultData create(@RequestBody SysLink SysLinkCreate){
        Command<SysLink> cmd = HttpServletCommandBuilder.get()
                .data(SysLinkCreate)
                .build();
        SysLinkService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysLinkService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable Integer id, @RequestBody SysLink SysLinkModify){
        SysLinkModify.setId(id);
        Command<SysLink> cmd = HttpServletCommandBuilder.get()
                .data(SysLinkModify)
                .build();
        SysLinkService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysLink menu = SysLinkService.findById(cmd);
        return ResultBuilder.getInstance()
                .data(menu)
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<SysLink>> search(SysLinkSearch SysLinkSearch){
        Command<SysLinkSearch> cmd = HttpServletCommandBuilder.get()
                .data(SysLinkSearch)
                .build();
        PageList<SysLink> pageList = SysLinkService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
