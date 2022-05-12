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
        return JSONResult.ok().data("user", userService.getUser(tel));
    }

    @RequestMapping("/register")
    public JSONResult register(@RequestParam String tel, @RequestParam String password) {
        if (userService.isExists(tel)) {
            return JSONResult.err().setMsg("用户已存在");
        }
        User res = userService.register(new User(tel, password));
        return JSONResult
                .ok()
                .setMsg("注册成功")
                .data("user", res);
    }

    @RequestMapping("/login")
    public JSONResult login(@RequestParam("tel") String tel, @RequestParam("password") String pwd) {
        User res = userService.getUser(tel);
        res.setShoppingCartId(Integer.parseInt(tel));

        if (!userService.isExists(tel)) {
            return JSONResult.err().setMsg("用户不存在");
        } else {
            if (Objects.equals(res.getPassword(), pwd)) {
                return JSONResult.ok().setMsg("登录成功").data("user", res);
            } else {
                return JSONResult.err().setMsg("密码错误");
            }
        }
    }

}
