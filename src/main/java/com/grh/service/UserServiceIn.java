package com.grh.service;


import com.grh.entites.Employee;
import com.grh.entites.User;

import java.util.List;

public interface UserServiceIn {
    public User createUser(User user);
    public List<User> finAllUser();
    public String updateUser(User user, Long id);
    public Boolean deleteUser(Long id);


}
