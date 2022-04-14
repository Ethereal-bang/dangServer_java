package dangserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/")
    public String user() {
        return "User";
    }

    @RequestMapping("/getUser")
    public String getUser(@RequestParam("tel") String tel) {
        return "Test";
    }

}
