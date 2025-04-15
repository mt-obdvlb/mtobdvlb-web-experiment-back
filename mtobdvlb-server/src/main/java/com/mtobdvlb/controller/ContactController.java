package com.mtobdvlb.controller;

import com.mtobdvlb.dto.ContactPageQueryDTO;
import com.mtobdvlb.entity.Contact;
import com.mtobdvlb.result.PageResult;
import com.mtobdvlb.result.Result;
import com.mtobdvlb.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/save")
    public Result save(@RequestBody Contact contact) {
        log.info("保存联系人信息：{}", contact);
        contactService.save(contact);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Contact> getById(@PathVariable Long id) {
        log.info("查询联系人信息：{}", id);
        return Result.success(contactService.getById(id));
    }

    @PutMapping
    public Result update(@RequestBody Contact contact) {
        log.info("修改联系人信息：{}", contact);
        contactService.update(contact);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        log.info("删除联系人信息：{}", id);
        contactService.delete(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result<PageResult> pageQuery(ContactPageQueryDTO contactPageQueryDTO) {
        log.info("分页查询联系人信息：{}", contactPageQueryDTO);
        PageResult pageResult = contactService.pageQuery(contactPageQueryDTO);
        return Result.success(pageResult);
    }

}
