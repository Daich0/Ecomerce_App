package com.ecomerce.fis.repository;

import com.ecomerce.fis.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findyEmail(String userName);
}
