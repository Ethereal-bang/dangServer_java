package dangserver.service;

import dangserver.pojo.User;

public interface UserService {

    boolean isExists(String tel);

    User getUser(String tel);

    User[] showAll();

}
