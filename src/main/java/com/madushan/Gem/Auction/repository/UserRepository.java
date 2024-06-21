package com.madushan.Gem.Auction.repository;

import com.madushan.Gem.Auction.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByActiveStatus(boolean activeStatus);

    User findByIdAndActiveStatus(int userId, boolean activeStatus);
}
