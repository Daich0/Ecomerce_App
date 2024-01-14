package com.ecomerce.fis.services;

import com.ecomerce.fis.models.ProductModel;
import com.ecomerce.fis.models.UserModel;
import com.ecomerce.fis.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel createUser(UserModel user){
        return userRepository.save(user);
    }
}
