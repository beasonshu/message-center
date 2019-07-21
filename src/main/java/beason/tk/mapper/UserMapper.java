package beason.tk.mapper;

import beason.tk.bean.User;
import beason.tk.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by shu.xinghu on 2018/6/27.
 */
@Mapper
public interface UserMapper extends MyMapper<User> {
    @Select("select * from user where username=#{username}")
    User selectByName(String username);

    @Select("select * from user where username=#{id}")
    User selectById(Long id);
}
