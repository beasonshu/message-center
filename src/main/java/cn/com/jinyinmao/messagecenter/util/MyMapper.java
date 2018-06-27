package cn.com.jinyinmao.messagecenter.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by shu.xinghu on 2018/6/27.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
