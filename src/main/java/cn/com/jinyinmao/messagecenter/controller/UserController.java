package cn.com.jinyinmao.messagecenter.controller;

import cn.com.jinyinmao.messagecenter.bean.User;
import cn.com.jinyinmao.messagecenter.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by shu.xinghu on 2018/6/28.
 */
@Api(tags = "测试用例")
@RestController
@MapperScan("cn.com.jinyinmao.messagecenter.mapper")
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserMapper mapper;

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUserList() {
       return mapper.selectAll();
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiParam(name = "user", value = "用户详细实体user", required = true)
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        return "success"+mapper.insert(user);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiParam(name = "id", value = "用户ID", required = true, type = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return mapper.selectById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiParam(name = "id", value = "用户ID", required = true, type = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiParam(name = "id", value = "用户ID", required = true)
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        mapper.deleteByPrimaryKey(id);
        return "success";
    }
}
