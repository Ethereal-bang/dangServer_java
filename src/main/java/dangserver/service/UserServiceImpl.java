package dangserver.service;

import dangserver.mapper.UserMapper;
import dangserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean isExists(String tel) {
        return 1 == userMapper.isExists(tel);
    }

    @Override
    public User getUser(String tel) {
        return userMapper.getUser(tel);
    }

    @Override
    public User[] showAll() {
        return userMapper.getAll();
    }

    @Override
    public User register(User user) {
        userMapper.addOne(user);
        return userMapper.getUser(user.getTel());
    }
}
