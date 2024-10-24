package com.yusheng.contactbackend1.controller;

import com.yusheng.contactbackend1.pojo.PageBean;
import com.yusheng.contactbackend1.pojo.People;
import com.yusheng.contactbackend1.pojo.Result;
import com.yusheng.contactbackend1.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    //查询所有人
    @GetMapping("/listPeople")
    public Result list(){

        System.out.println("查询全部人数据");

        List<People> peopleList = peopleService.list();
        return Result.success(peopleList);
    }

    //根据id删除
    @DeleteMapping("/listPeople/{id}")
    public Result delete(@PathVariable Integer id){

        peopleService.delete(id);
        return Result.success();
    }

    //添加人

    @PostMapping("/listPeople")
    public Result addPeople(@RequestBody People people)
    {

        peopleService.addPeople(people);
        return Result.success();
    }

    //修改人
    @PostMapping("/updatePeople")
    public Result updatePeople(@RequestBody People people)
    {

        peopleService.updatePeople(people);
        return Result.success();
    }

    @GetMapping("/pageListPeople")
    public Result page(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10")Integer pageSize, String searchPeopleName, Short searchPeopleGender){

        PageBean pageBean = peopleService.page(page,pageSize, searchPeopleName, searchPeopleGender);
        return Result.success(pageBean);
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){//不写注释会报错

        People people = peopleService.selecetById(id);
        return Result.success(people);
    }



//    @GetMapping("/selectById")
//    public Result selectById(@RequestParam Integer id){
//
//        People people = peopleService.selecetById(id);
//        return Result.success(people);
//    }

}
