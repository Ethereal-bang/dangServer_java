package dangserver.service;

public interface ShoppingCartService {

    boolean addOneGoods(String tel, int id, int num);

    int[] getGoodsIdList(String tel);

}
