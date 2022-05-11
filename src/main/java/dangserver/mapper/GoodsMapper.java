package dangserver.mapper;

import dangserver.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsMapper {
    Goods[] getAll();

    int getCount();

    Goods[] getByType(Object type); // Object只是为了和Service对应

    Goods[] getById(Object id);
}
