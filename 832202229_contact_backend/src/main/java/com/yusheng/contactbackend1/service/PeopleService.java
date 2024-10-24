package com.yusheng.contactbackend1.service;

import com.yusheng.contactbackend1.pojo.PageBean;
import com.yusheng.contactbackend1.pojo.People;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PeopleService {


    //查询全部人数据
    List<People> list();

    void delete(Integer id);

    void addPeople(People people);

    PageBean page(Integer page, Integer pageSize, String searchPeopleName, Short searchPeopleGender);

    People selecetById(Integer id);

    void updatePeople(People people);
}
