package com.grh.service;

import com.grh.entites.User;
import com.grh.reposetory.UserReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
 @Autowired
private UserReposetory repo;


 public User createUser(User user){
  return repo.save(user);
 }

 public List<User> findAllUser(){
  return repo.findAll();
 }

 public Boolean deleteUser(Long id) {
  Optional<User> UserOptional = repo.findById(id);
  if(UserOptional.isPresent()){
   repo.deleteById(id);
   return true;
  }
  return false;
 }

 public String updateUser(User user, Long id){
  Optional<User> UserOptional=repo.findById(id);
  if(UserOptional.isPresent()){
   User updateUser = UserOptional.get();
   updateUser.setName(user.getName());

  }

  return "";
 }









}
