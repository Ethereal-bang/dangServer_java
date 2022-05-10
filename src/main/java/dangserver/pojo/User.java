package dangserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String tel, password, address;

    public User(String tel, String pwd) {
        this.tel = tel;
        password = pwd;
    }
}
