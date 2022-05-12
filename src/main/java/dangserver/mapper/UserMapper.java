package dangserver.mapper;

import dangserver.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    // 查询该tel是否注册
    int isExists(String tel);

    // 由tel获得user所有信息
    User getUser(String tel);

    // 返回所有
    User[] getAll();

    // 新增行
    void addOne(User user);

    void updateCartInfo(User user);
}
