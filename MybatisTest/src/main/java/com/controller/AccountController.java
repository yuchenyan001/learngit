package com.controller;

import com.entity.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    //通过属性找到另一个属性 通过普通类型找普通类型
    @RequestMapping("hello")
    public String helloSpringBoot(){
        String name=accountService.getStringById();
        return name;
    }

    //通过属性找对象 通过普通类型找实体类
    @RequestMapping("getEntityBycolumn")
    public Account getEntityBycolumn(){
        Account account =accountService.getAccountById();
        return account;
    }

    //返回的是一个List，但是mapper层resultMap是Account，dao层是List<Account>
    @RequestMapping("getAllAccount")
    public List<Account> getAllAccount(){
        List<Account> accountList =accountService.getAllAccount();
        return accountList;
    }

    //返回的是map
    @RequestMapping("getAccountAsMapById")
    public Map<String,Object> getAccountAsMapById(){
        Map<String,Object> accountMap =accountService.getAccountAsMapById();
        return accountMap;
    }

    //Param是普通属性
    @RequestMapping("getAccountByIdParam")
    public Account getAccountByIdParam(){
        Account account =accountService.getAccountByIdParam();
        return account;
    }

    //Param是对象
    @RequestMapping("getAccountByEntityParam")
    public List<Account> getAccountByEntityParam(){
        List<Account> account =accountService.getAccountByEntityParam();
        return account;
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
