package dangserver.controller;

import dangserver.common.JSONResult;
import dangserver.pojo.User;
import dangserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String user() {
        return "User";
    }

    @RequestMapping("/_showAll")
    public User[] showAll() {
        return userService.showAll();
    }

    @RequestMapping("/getUser/{tel}")
    public JSONResult getUser(@PathVariable String tel) {
        return JSONResult.ok(userService.getUser(tel));
    }

    @RequestMapping("/register")
    public JSONResult register(@RequestParam String tel, @RequestParam String password) {
        if (userService.isExists(tel)) {
            return JSONResult.err().setMsg("用户已存在");
        }
        return JSONResult
                .ok(userService.register(new User(tel, password)))
                .setMsg("注册成功");
    }

    @RequestMapping("/login")
    public JSONResult login(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd) {
        if (!userService.isExists(tel)) {
            return JSONResult.err().setMsg("用户不存在");
        } else {
            if (Objects.equals(userService.getUser(tel).getPassword(), pwd)) {
                return JSONResult.ok(true).setMsg("登录成功");
            } else {
                return JSONResult.err().setMsg("密码错误");
            }
        }
    }

}
