package com.joni.service;

import com.joni.model.Person;
import com.joni.model.User;
import com.joni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by shenjj on 2017/4/6.
 */

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private UserRepository userRepository;

    public void insertUser(User user) {
        mongoOperations.insert(user, "User");
        System.out.println("insert user=" + user.toString());
    }


    public User findUserByName(String userName) {
//        User user = mongoOperations.findOne(new Query(Criteria.where("userName").is(userName)), User.class);
        List<User> user = userRepository.findByUserName(userName);
        System.out.println("user=" + user);
        return user.get(0);
//        return userRepository.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.printf("find user=" + username);

        List<User> userList = mongoOperations.find(new Query(where("userName").is(username)), User.class);
        User user = userList.get(0);

//        User user=new User("sss","ssss");

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPass(),
                grantedAuthorities
        );
    }
}
