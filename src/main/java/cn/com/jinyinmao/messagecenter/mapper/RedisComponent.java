package cn.com.jinyinmao.messagecenter.mapper;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import com.alibaba.fastjson.JSON;

/**
 * Created by shu.xinghu on 2018/6/28.
 */
@Component
public class RedisComponent {
    @Autowired
    //操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集
    private StringRedisTemplate stringRedisTemplate;

    private Logger logger = LoggerFactory.getLogger(RedisComponent.class);

    @Autowired
    // RedisTemplate，可以进行所有的操作
    private RedisTemplate<Object, Object> redisTemplate;

    public void set(String key, String value) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        boolean bExistent = this.stringRedisTemplate.hasKey(key);
        if (bExistent) {
            logger.info("this key is bExistent!");
        } else {
            ops.set(key, value);
        }
    }

    public String get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    public void del(String key) {
        this.stringRedisTemplate.delete(key);
    }

    public void sentinelSet(String key, Object object) {
        redisTemplate.opsForValue().set(key, JSON.toJSONString(object));
    }

    public String sentinelGet(String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }
}
