package dangserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    private String tel;
    private int goodsId;

    public ShoppingCart(String tel) {
        this.tel = tel;
    }
}
