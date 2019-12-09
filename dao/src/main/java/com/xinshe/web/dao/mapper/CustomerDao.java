package com.xinshe.web.dao.mapper;

import com.xinshe.web.dao.entity.Customer;
import com.xinshe.web.dao.entity.CustomerQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao {
    int countByExample(CustomerQuery example);

    int deleteByExample(CustomerQuery example);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerQuery example);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerQuery example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerQuery example);
}