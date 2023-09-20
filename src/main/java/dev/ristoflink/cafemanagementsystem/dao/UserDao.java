package dev.ristoflink.cafemanagementsystem.dao;

import dev.ristoflink.cafemanagementsystem.pojo.User;
import dev.ristoflink.cafemanagementsystem.wrapper.UserWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmailId(@Param("email") String email);

    List<UserWrapper> getAllUsers();
}
