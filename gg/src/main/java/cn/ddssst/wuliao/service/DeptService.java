package cn.ddssst.wuliao.service;

import cn.ddssst.wuliao.model.Dept;
import cn.ddssst.wuliao.request.SendRequest;

import java.util.List;

public interface DeptService {

    public List<Dept> list();

    String send(SendRequest sendRequest);

}
