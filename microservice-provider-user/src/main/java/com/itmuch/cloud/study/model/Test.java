package com.itmuch.cloud.study.model;

import lombok.Data;

import java.util.Date;

@Data
public class Test {
	
	private final long id;
    private final String content;
    private Date time;

    public Test(long id, String content) {
        this.id = id;
        this.content = content;
        this.time = new Date();
    }

    public Test(long id, String content, Date time) {
        this.id = id;
        this.content = content;
        this.time = time;
    }

}
