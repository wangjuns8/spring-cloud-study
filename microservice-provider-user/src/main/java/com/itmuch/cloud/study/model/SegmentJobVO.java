package com.itmuch.cloud.study.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SegmentJobVO {
    private String segmentjobid;
    private String batchcode;
    private String segmentid;
    //接受application.yml里设置的全局时间格式：yyyy-MM-dd HH:mm:ss
    private Date planstarttime;
    private String jobstate;
    private String units;

    public SegmentJobVO(String segmentjobid, String batchcode, String segmentid, Date planstarttime, String jobstate, String units) {
        this.segmentjobid = segmentjobid;
        this.batchcode = batchcode;
        this.segmentid = segmentid;
        this.planstarttime = planstarttime;
        this.jobstate = jobstate;
        this.units = units;
    }
}
