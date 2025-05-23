package com.madushan.Gem.Auction.Back.End.repository;

import com.madushan.Gem.Auction.Back.End.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findByIsActiveTrue();
}
