package cn.ddssst.wuliao.controller;


import cn.ddssst.wuliao.model.Dept;
import cn.ddssst.wuliao.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
