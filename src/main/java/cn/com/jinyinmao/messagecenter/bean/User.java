package cn.com.jinyinmao.messagecenter.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by shu.xinghu on 2018/6/27.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User extends BaseEntity{
    private String username;
    private String idCard;
    private String phone;
    private String password;
}
