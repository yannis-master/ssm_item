package com.yangbin.dao;

import com.yangbin.domain.Items;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsDao {
    @Select("select * from items")
    List<Items> queryItems();
    @Select("select * from items where id = #{id}")
    Items findItemsById(Integer id);
    @Update("update items set name=#{name},price=#{price},pic=#{pic},createtime=#{createtime},detail=#{detail} where id=#{id}")
    void updateItems(Items items);
}
