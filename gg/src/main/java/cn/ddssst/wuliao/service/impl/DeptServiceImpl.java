package cn.ddssst.wuliao.service.impl;

import cn.ddssst.wuliao.example.DeptExample;
import cn.ddssst.wuliao.mapper.DeptMapper;
import cn.ddssst.wuliao.model.Dept;
import cn.ddssst.wuliao.request.SendRequest;
import cn.ddssst.wuliao.service.DeptService;
import cn.ddssst.wuliao.util.Template;
import cn.ddssst.wuliao.util.TemplateParam;
import cn.ddssst.wuliao.util.WXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> list() {
        return deptMapper.selectByExample(new DeptExample());
    }

    public String send(SendRequest sendRequest) {
        try {
            Template template = new Template();
            template.setToUser("oPSpuwy9NAMPjondXuovc8EOGNZE");
            template.setTemplateId("oUsJWiuEO_lLjgGmsKx8ADLhvRfRK88yIYsuhKXdnts");
            template.setTopColor("red");
            template.setUrl("www.ddssst.cn");
            template.setTemplateParamList(sendRequest);
            String token=WXUtils.accessToken("wx33c54612a173e93c","5fe77e00254562bde4e78058eee6fb63");
            WXUtils.sendTemplateMsg(token,template);
            return template.toJSON();
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
