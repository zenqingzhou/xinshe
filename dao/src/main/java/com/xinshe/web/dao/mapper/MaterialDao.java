package com.xinshe.web.dao.mapper;

import com.xinshe.web.dao.entity.Material;
import com.xinshe.web.dao.entity.MaterialQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialDao {
    int countByExample(MaterialQuery example);

    int deleteByExample(MaterialQuery example);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialQuery example);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialQuery example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialQuery example);
}