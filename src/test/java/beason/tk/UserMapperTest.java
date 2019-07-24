package beason.tk;

import beason.tk.bean.User;
import beason.tk.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by shu.xinghu on 2018/6/28.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("cn.com.jinyinmao.messagecenter.mapper")
public class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    

    @Test
    public void testInset() {
        User user = new User("Jaycekon",15618660965,"1234","123");
        int i = mapper.insert(user);
        Assert.assertNotEquals(0, i);
    }


    @Test
    public void testSelect(){
        User user = mapper.selectByName("Jaycekon");
        Assert.assertNotEquals(null,user);
    }
}
