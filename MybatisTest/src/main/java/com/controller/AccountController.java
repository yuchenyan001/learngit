package com.controller;

import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("hello")
    public String helloSpringBoot(){
        String name=accountService.getStringById();
        return name;
    }

    @RequestMapping("listList")
    public String listList(){
        accountService.getListLlist();
        return "name";
    }

    @RequestMapping("file")
    public String file(){
        accountService.readCSV("aa");
        return "name";
    }

    @RequestMapping("returnString")
    public String returnString(){
        accountService.readCSV("aa");
        return "name";
    }
}
