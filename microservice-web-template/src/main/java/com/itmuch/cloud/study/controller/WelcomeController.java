package com.itmuch.cloud.study.controller;

import com.itmuch.cloud.study.model.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    @Value("${user}")
    private String userName;

    @RequestMapping("/welcome")
    public String index(Model map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", userName);
        // return模板文件的名称，对应src/main/resources/templates/welcome.ftl
        return "welcome";
    }

    @GetMapping(value="/cities")
    public ModelAndView showCities() {
        List<City> cities = new ArrayList();

        cities.add(new City(1L, "shenyang", "liaoning"));
        cities.add(new City(2L, "beijing", "china"));

        Map params = new HashMap<String, Object>();
        params.put("cities", cities);

        return new ModelAndView("showCities", params);
    }

}

