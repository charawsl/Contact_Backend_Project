package com.yusheng.contactbackend1.mapper;

import com.yusheng.contactbackend1.pojo.People;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PeopleMapper {
    //查询全部部门数据
    @Select("select * from people")
    public List<People> list();

    //根据id删除部门
    @Delete("delete from people where id = #{id}")
    public void delete(Integer id);

    @Insert("insert into people(name, gender, phone, address, create_time, update_time) values(#{name},#{gender},#{phone},#{address},#{createTime},#{updateTime})")
    public void addPeople(People people);

    @Select("select count(*) from people")
    public Long count();

    // @Select("select * from people limit #{start},#{pageSize} where name like")
    public List<People> page(Integer start, Integer pageSize , String searchPeopleName, Short searchPeopleGender);

    @Select("select * from people where id = #{id}")
    public People selectById(Integer id);


    public void updatePeople(People people);
}
