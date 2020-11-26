package com.itmuch.cloud.study.model;

import lombok.Data;

import java.util.Date;

@Data
public class SegmentJobVO {
    private String segmentjobid;
    private String batchcode;
    private String segmentid;
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
