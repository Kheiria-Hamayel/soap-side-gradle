package com.example.soapside.service;

import com.soap_side.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final Map<String, User> users = new HashMap<>();
    @PostConstruct
    public void initial(){
        User Amy = new User();
        Amy.setName("Amy");
        Amy.setEmpId(1111);
        Amy.setSalary(112.5);
        users.put(Amy.getName(),Amy);

        User bob = new User();
        bob.setName("Bob");
        bob.setEmpId(1112);
        bob.setSalary(112.5);
        users.put(bob.getName(),bob);
        User Alice = new User();
        Alice.setName("Alice");
        Alice.setEmpId(1113);
        Alice.setSalary(112.5);
        users.put(Alice.getName(),Alice);



    }

    public User getUser (String uName){
        return users.get(uName);
    }
}
