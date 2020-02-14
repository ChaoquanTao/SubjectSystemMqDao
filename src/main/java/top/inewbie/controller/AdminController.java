package top.inewbie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.inewbie.pojo.ReqResult;
import top.inewbie.pojo.User;
import top.inewbie.service.UserService;


@Controller

public class AdminController {

    @Autowired
    private UserService userService ;
    /**
     * 正常来讲，我们这里返回的应该是一个token,该token应该是service层查询数据库后生成的，
     * 包含了用户是否应该登录，以及过期时间
     * 这里先忽略持久层，直接在Controller这里生成一个token
     * 以后客户端要发请求，都带着这个token一起发，我们根据token里的内容给它指示
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    ReqResult login(@RequestBody User user){

        String userName = user.getUserName();
        String passWord = user.getPassWord();
        System.out.println("test---");
        return userService.login(userName,passWord) ;

    }
//    public @ResponseBody String login(String userName,
//                                             String passWord){
//
//        System.out.println(userName+"================"+passWord);
//        User adm = new User();
//        adm.setUserName("dddd");
//        adm.setPassWord("sfdadfa");
//        /**根据用户名密码查询数据库并返回相应结果*/
//
//        return "ddddddddddddddd" ;
//
//    }




}
