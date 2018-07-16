package cn.ddssst.wuliao.mapper;

import cn.ddssst.wuliao.example.accessTokenExample;
import cn.ddssst.wuliao.model.accessToken;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface accessTokenMapper {
    long countByExample(accessTokenExample example);

    int deleteByExample(accessTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(accessToken record);

    int insertSelective(accessToken record);

    List<accessToken> selectByExample(accessTokenExample example);

    accessToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") accessToken record, @Param("example") accessTokenExample example);

    int updateByExample(@Param("record") accessToken record, @Param("example") accessTokenExample example);

    int updateByPrimaryKeySelective(accessToken record);

    int updateByPrimaryKey(accessToken record);
}