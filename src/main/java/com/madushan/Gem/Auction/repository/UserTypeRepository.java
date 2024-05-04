package com.madushan.Gem.Auction.repository;

import com.madushan.Gem.Auction.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
}
