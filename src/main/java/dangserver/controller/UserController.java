package dangserver.controller;

import dangserver.common.JSONResult;
import dangserver.pojo.User;
import dangserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String user() {
        return "User";
    }

    @RequestMapping("/getUser")
    public JSONResult<User> getUser(@RequestParam("tel") String tel) {
//        if (userService.isExists(tel)) {
//            return "用户存在";
//        } else {
//            return "用户不存在";
//        }
        return new JSONResult<User>(userService.getUser(tel));
    }

    @RequestMapping("/login")
    public JSONResult login(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd) {
        if (!userService.isExists(tel)) {
            return new JSONResult<String>(false, "用户不存在");
        } else {
            if (Objects.equals(userService.getUser(tel).getPassword(), pwd)) {
                JSONResult<Boolean> res = new JSONResult<>(true);
                res.setMsg("登录成功");
                return res;
            } else {
                return new JSONResult<String>(false, "密码错误");
            }
        }
    }

}
