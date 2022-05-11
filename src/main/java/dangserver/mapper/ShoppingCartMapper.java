package dangserver.mapper;

import dangserver.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper {
    int add(ShoppingCart shoppingCart);
}
