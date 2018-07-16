package cn.ddssst.wuliao.service.impl;

import cn.ddssst.wuliao.example.DeptExample;
import cn.ddssst.wuliao.mapper.DeptMapper;
import cn.ddssst.wuliao.model.Dept;
import cn.ddssst.wuliao.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> list() {
        return deptMapper.selectByExample(new DeptExample());
    }
}
