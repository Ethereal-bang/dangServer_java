package dangserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String tel, password, address;

    private int cart_count, shoppingCartId = 0;

    private float cart_price;

    public User(String tel, String pwd) {
        this.tel = tel;
        password = pwd;
        shoppingCartId = Integer.parseInt(tel);
    }

    public User(int count, float price, String tel) {   // 购物车信息
        cart_count = count;
        cart_price = price;
        this.tel = tel;
    }
}
