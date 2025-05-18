package com.madushan.Gem.Auction.Back.End.service;

import com.madushan.Gem.Auction.Back.End.entity.Auction;

import java.util.List;

public interface AuctionService {

    Auction createAuction(Auction auction, String name);

    List<Auction> getAllActiveAuctions();

    Auction updateAuction(Long id, Auction auction, String name);

    void deleteAuction(Long id, String name);
}
