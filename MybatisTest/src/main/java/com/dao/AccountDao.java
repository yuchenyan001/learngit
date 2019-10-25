package com.dao;


import com.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface AccountDao {

    String getStringById(Integer id);

    Account getAccountById(Integer id);

    // 假如是全表查询数据，将查询的数据封装成 Account 类型的集合，mapper层返回的是Account，dao层返回的是List<Account>
    List<Account> getAllAccount();

    //  根据 id 查询信息，并把结果信息封装成 Map
    Map<String, Object> getAccountAsMapById(Integer id);

    //@param 注解单一属性 这个param必须要与mapper中一致
    Account getAccountByIdParam(@Param("accountName") String accountName, @Param("accountId") String accountId);

    List<Account> getAccountByEntityParam(@Param("account") Account user);

    List<Account> getListList(@Param("idList") List<List<String>> splitList);

}
