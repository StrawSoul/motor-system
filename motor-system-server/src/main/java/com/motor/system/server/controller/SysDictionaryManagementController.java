package com.motor.system.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.message.http.servlet.HttpServletCommandBuilder;
import com.motor.system.server.command.SysDictionarySearch;
import com.motor.system.server.dictionary.SysDictionary;
import com.motor.system.server.service.SysDictionaryManagementService;
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
@RequestMapping("management/system/dictionary")
public class SysDictionaryManagementController {
    @Autowired
    SysDictionaryManagementService sysDictionaryService;

    @PostMapping
    public ResultData create(@RequestBody SysDictionary SysDictionaryCreate){
        Command<SysDictionary> cmd = HttpServletCommandBuilder.get()
                .data(SysDictionaryCreate)
                .build();
        sysDictionaryService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        sysDictionaryService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable Integer id, @RequestBody SysDictionary SysDictionaryModify){
        SysDictionaryModify.setId(id);
        Command<SysDictionary> cmd = HttpServletCommandBuilder.get()
                .data(SysDictionaryModify)
                .build();
        sysDictionaryService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable Integer id){
        Command<Integer> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        SysDictionary menu = sysDictionaryService.findById(cmd);
        return ResultBuilder.getInstance()
                .data(menu)
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<SysDictionary>> search(SysDictionarySearch SysDictionarySearch){
        Command<SysDictionarySearch> cmd = HttpServletCommandBuilder.get()
                .data(SysDictionarySearch)
                .build();
        PageList<SysDictionary> pageList = sysDictionaryService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
