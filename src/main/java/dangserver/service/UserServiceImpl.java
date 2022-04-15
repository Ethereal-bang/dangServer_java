package dangserver.service;

import dangserver.mapper.UserMapper;
import dangserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {}

    @Override
    public boolean isExists(String tel) {
        return 1 == userMapper.isExists(tel);
    }

    @Override
    public User getUser(String tel) {
        return userMapper.getUser(tel);
    }
}
