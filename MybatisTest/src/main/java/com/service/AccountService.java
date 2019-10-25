package com.service;

import com.dao.AccountDao;
import com.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    //入参是常规类型，resulttype是普通类型
    public String getStringById() {
        String name = accountDao.getStringById(2);
        System.out.println(name);
        return name;
    }

    //入参是常规类型，resulttype是普通类型
    public Account getAccountById() {
        Account account = accountDao.getAccountById(2);
        System.out.println(account.toString());
        return account;
    }

    public List<Account> getAllAccount() {
        List<Account> accountList = accountDao.getAllAccount();
        System.out.println(accountList.toString());
        return accountList;
    }

    //获取map类型
    public Map<String, Object> getAccountAsMapById() {
        Map<String, Object> accountMap = accountDao.getAccountAsMapById(2);
        System.out.println(accountMap);
        return accountMap;
    }

    //获取Account 入参@Param 是普通属性
    public Account getAccountByIdParam() {
        Account accountParam = accountDao.getAccountByIdParam("admin1", "1");
        System.out.println(accountParam);
        return accountParam;
    }

    //获取Account 入参@Param 是对象
    public List<Account> getAccountByEntityParam() {
        Account account = new Account();
        account.setAccountName("a");
        List<Account> accountParam = accountDao.getAccountByEntityParam(account);
        System.out.println(accountParam);
        return accountParam;
    }


    //入参是List<List<String>>  数据库操作是
    public List<Account> getListLlist() {
        List<List<String>> listList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        listList.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("4");
        listList.add(list2);
        List<Account> acoountList = accountDao.getListList(listList);
        System.out.println(acoountList);
        return acoountList;
    }

    public <T> List<List<T>> getSumArrayList(List<T> list) {
        List<List<T>> objectlist = new ArrayList<>();
        int iSize = list.size() / 500;
        int iCount = list.size() % 500;
        for (int i = 0; i <= iSize; i++) {
            List<T> newObjList = new ArrayList<>();
            if (i == iSize) {
                for (int j = i * 500; j < i * 500 + iCount; j++) {
                    newObjList.add(list.get(j));
                }
            } else {
                for (int j = i * 500; j < (i + 1) * 500; j++) {
                    newObjList.add(list.get(j));
                }
            }
            if (newObjList.size() > 0) {
                objectlist.add(newObjList);
            }
        }
        return objectlist;
    }

    public List<Account> readCSV(String fileName) {
        List<Account> accountList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\yuchenyan\\Desktop\\a.csv"));// 文件名
//            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {
                Account account = new Account();
                String item[] = line.split(",");// CSV格式文件为逗号分隔符文件，这里根据逗号切分
                account.setAccountId(item[0]);
                account.setAccountName(item[1]);
                account.setBalance(item[2]);
                accountList.add(account);
            }
//                System.out.println("从CSV中读取到的数据：" + kgInfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(accountList);
        return accountList;
    }


}
