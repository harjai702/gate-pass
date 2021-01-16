package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontroll2 {
    @Autowired
    datarepo repo;
    @Autowired
    userrepo usrepo;
    @RequestMapping("abc")
    @Transactional
    public void abc(){
        data1 da=new data1();
        users usr=new users();
        da.setIdd(30);
        da.setStatus("approved");
        da.setDate("12343");
        da.setDate2("23453");
        da.setNme("hello3");
        da.setTime("12343");
        da.setTime2("23453");
        repo.save(da);
        usr.setPassword("hello3");
        usr.setEmail("abc@exp.com");
        usr.setFlname("hello3");
        usr.setMber("1234563");
        usr.setUsername("12343");
        usrepo.save(usr);
    }
}
