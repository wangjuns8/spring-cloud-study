package com.itmuch.cloud.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.itmuch.cloud.study.model.Result;
import com.itmuch.cloud.study.model.SegmentJobVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/segment")
@Slf4j
public class SegmentController {

    @GetMapping("/listSegmentJob")
    public Result listSegmentJob(@RequestParam(value="segmentid") String segmentid) {

        if(StringUtils.isBlank(segmentid)) {
//            return JSONObject.toJSONString(new Result(1, "段类型不可以为空！"));
            return new Result(1, "段类型不可以为空！");
        } else if(!segmentid.equals("21") && !segmentid.equals("22")) {
//            return JSONObject.toJSONString(new Result(2, "段类型不对！"));
            return new Result(1, "段类型不可以为空！");
        }

        List<SegmentJobVO> data = new ArrayList<>();

        if(segmentid.equals("21"))
            data.add(new SegmentJobVO("adf15345", "1111111", "21", new Date(), "117", "211,212"));
        else
            data.add(new SegmentJobVO("adf15345", "1111111", "22", new Date(), "117", "221,222,223,224"));

//        return JSONObject.toJSONString(new Result(0, "SUCCESS", data));
        return new Result(0, "SUCCESS", data);
    }

//    String strDate() {
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String str = sf.format(new Date());
//        return str;
//    }
}
