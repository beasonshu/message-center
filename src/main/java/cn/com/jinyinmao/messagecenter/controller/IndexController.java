package cn.com.jinyinmao.messagecenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shu.xinghu on 2018/6/28.
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/index",produces = "text/plain;charset=UTF-8")
    public String index(){
        return "Hello World加进来";
    }
}
