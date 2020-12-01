package com.wj.microservice.nacosconfig.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Test {
	
	private long id;
    private String content;
    //接受application.yml里设置的全局时间格式：yyyy-MM-dd HH:mm:ss
    private Date time;
    //@JsonFormat优先级高于全局配置
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date date;

    public Test(){}

    public Test(long id, String content) {
        this.id = id;
        this.content = content;
        this.time = new Date();
        this.date = new Date();
    }

    public Test(long id, String content, Date time) {
        //构造函数中调用构造函数，但是只可以调用一次
        //并且构造函数的调用必须在第一位，否则将会出现编译时错误。
        this(id, content);
        if(time != null) this.time = time;
    }

    public Test(long id, String content, Date time, Date date) {
        //构造函数中调用构造函数，但是只可以调用一次
        //并且构造函数的调用必须在第一位，否则将会出现编译时错误。
        this(id, content, time);
        if(date != null) this.date = date;
    }
}
