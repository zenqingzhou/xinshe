package com.xinshe.web.dao.mapper;

import com.xinshe.web.dao.entity.StorageLogs;
import com.xinshe.web.dao.entity.StorageLogsQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageLogsDao {
    int countByExample(StorageLogsQuery example);

    int deleteByExample(StorageLogsQuery example);

    int insert(StorageLogs record);

    int insertSelective(StorageLogs record);

    List<StorageLogs> selectByExample(StorageLogsQuery example);

    int updateByExampleSelective(@Param("record") StorageLogs record, @Param("example") StorageLogsQuery example);

    int updateByExample(@Param("record") StorageLogs record, @Param("example") StorageLogsQuery example);
}