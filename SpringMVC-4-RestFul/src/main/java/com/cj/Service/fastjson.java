package com.cj.Service;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.cj.pojo.User;
import com.cj.utils.jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RestController//在类上直接使用 @RestController ，这样子，里面所有的方法都只会返回 json 字符串了，不用再每一个都添加@ResponseBody ！我们在前后端分离开发中，一般都使用
@Controller
public class fastjson {
//    ==================================================JSON测试======================================================================
    public List<User> getUsers(){
        User user1 = new User(1,"保罗","男");
        User user2 = new User(2,"哈登","男");
        User user3 = new User(3,"库里","男");
        User user4 = new User(4,"阿德托伦博","男");
        List<User> users=new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return users;
    }

    @RequestMapping(value = "/j1",produces =  "application/json;charset=utf-8")
    @ResponseBody
    public String jack_json(Model model) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String str_json=objectMapper.writeValueAsString(getUsers());
        model.addAttribute("MSG",str_json);
        System.out.println(str_json);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str_json;
    }

    @GetMapping(value = "j2",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json_date() throws JsonProcessingException {
        Date data = new Date();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str_date=simpleDateFormat.format(data);
        return objectMapper.writeValueAsString(str_date);
    }

    @GetMapping(value = "j3",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json_date2() throws JsonProcessingException {
        Date data = new Date();
        ObjectMapper objectMapper = jackson.get_jacksonMapper();
        String str=objectMapper.writeValueAsString(data);
        return str;
    }

//    @GetMapping(value = "j4",produces = "application/json;charset=utf-8")
//    @ResponseBody
    @Test
    public void fastjson_test(){
        List<User> users=getUsers();
        User user=users.get(2);
        JSONObject json_user=(JSONObject) JSON.toJSON(user);
//        System.out.println(json_user);
        String str_jsons=JSON.toJSONString(users);
        System.out.println(str_jsons);
        User user1=JSON.toJavaObject(json_user,User.class);
        System.out.println(user1);
//        return json_user;
    }
}
