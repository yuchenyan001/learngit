package com.dao;


import com.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface AccountDao {

    String getStringById(Integer id);

    List<Account> getListList(@Param("idList")List<List<String>> splitList);

}
