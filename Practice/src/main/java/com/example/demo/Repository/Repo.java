package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UserEntity;
@Repository
public interface Repo extends JpaRepository<UserEntity,Integer> {

}
