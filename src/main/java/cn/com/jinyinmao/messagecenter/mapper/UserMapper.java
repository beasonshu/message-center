package cn.com.jinyinmao.messagecenter.mapper;

import cn.com.jinyinmao.messagecenter.bean.User;
import cn.com.jinyinmao.messagecenter.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by shu.xinghu on 2018/6/27.
 */
@Mapper
public interface UserMapper extends MyMapper<User> {
    @Select("select * from user where username=#{username}")
    User selectByName(String username);
}
