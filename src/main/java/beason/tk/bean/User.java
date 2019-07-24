package beason.tk.bean;
import javax.persistence.Column;

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
	@Column(name = "user_name")
    private String username;
	@Column(name = "id_card")
    private String idCard;
    private int phone;
    private String password;
}
