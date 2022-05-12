package dangserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String tel, password, address;

    private int cart_count, cart_price, shoppingCartId = 0;

    public User(String tel, String pwd) {
        this.tel = tel;
        password = pwd;
        shoppingCartId = Integer.parseInt(tel);
    }
}
