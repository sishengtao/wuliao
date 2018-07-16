package cn.ddssst.wuliao.controller;


import cn.ddssst.wuliao.model.Dept;
import cn.ddssst.wuliao.request.SendRequest;
import cn.ddssst.wuliao.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list();
}

    @GetMapping("/send")
    public String send( SendRequest sendRequest){
        return deptService.send(sendRequest);
    }
}
