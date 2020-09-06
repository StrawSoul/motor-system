package com.motor.system.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.message.http.servlet.HttpServletCommandBuilder;
import com.motor.system.server.command.SysDictionaryOptionSearch;
import com.motor.system.server.dictionary.SysDictionaryOption;
import com.motor.system.server.service.SysDictionaryOptionManagementService;
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
@RequestMapping("management/system/dictionary/option")
public class SysDictionaryOptionManagementController {

    @Autowired
    SysDictionaryOptionManagementService SysDictionaryOptionService;

    @PostMapping
    public ResultData create(@RequestBody SysDictionaryOption SysDictionaryOptionCreate){
        Command<SysDictionaryOption> cmd = HttpServletCommandBuilder.get()
                .data(SysDictionaryOptionCreate)
                .build();
        SysDictionaryOptionService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysDictionaryOptionService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable Integer id, @RequestBody SysDictionaryOption SysDictionaryOptionModify){
        SysDictionaryOptionModify.setId(id);
        Command<SysDictionaryOption> cmd = HttpServletCommandBuilder.get()
                .data(SysDictionaryOptionModify)
                .build();
        SysDictionaryOptionService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysDictionaryOption menu = SysDictionaryOptionService.findById(cmd);
        return ResultBuilder.getInstance()
                .data(menu)
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<SysDictionaryOption>> search( SysDictionaryOptionSearch SysDictionaryOptionSearch){
        Command<SysDictionaryOptionSearch> cmd = HttpServletCommandBuilder.get()
                .data(SysDictionaryOptionSearch)
                .build();
        PageList<SysDictionaryOption> pageList = SysDictionaryOptionService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
