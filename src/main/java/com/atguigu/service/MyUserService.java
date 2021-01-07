package com.atguigu.service;

import com.atguigu.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class MyUserService implements UserDetailsService {

    static Map<String, User> map = new HashMap<String, User>();
    static {
        map.put("zhangsan",new User("zhangsan","$2a$10$N8m2rGySJqt5qJ2EcEbpheK2FJJkJ6obpNGy0wdfnTEabKeJDzGBy",18,1));
        map.put("lisi",new User("lisi","$2a$10$N8m2rGySJqt5qJ2EcEbpheK2FJJkJ6obpNGy0wdfnTEabKeJDzGBy",18,1));
        map.put("wangwu",new User("wangwu","$2a$10$N8m2rGySJqt5qJ2EcEbpheK2FJJkJ6obpNGy0wdfnTEabKeJDzGBy",18,1));
        map.put("zhaoliu",new User("zhaoliu","$2a$10$N8m2rGySJqt5qJ2EcEbpheK2FJJkJ6obpNGy0wdfnTEabKeJDzGBy",18,1));

    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = map.get(name);
        if(user == null){
            return null;
        }

        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        if(name.equals("zhangsan")){

        }else if(name.equals("lisi")){
            list.add(new SimpleGrantedAuthority("ROLE_ABC"));
        }else if (name.equals("wangwu")){
            list.add(new SimpleGrantedAuthority("ROLE_DEF"));
        }else if(name.equals("zhaoliu")){
            list.add(new SimpleGrantedAuthority("dd"));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),list);

    }
}
