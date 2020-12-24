package com.example.mywebapp;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,String> {

}
