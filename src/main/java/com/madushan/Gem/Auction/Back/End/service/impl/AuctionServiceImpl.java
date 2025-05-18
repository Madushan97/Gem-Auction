package com.madushan.Gem.Auction.Back.End.service.impl;

import com.madushan.Gem.Auction.Back.End.entity.Auction;
import com.madushan.Gem.Auction.Back.End.entity.User;
import com.madushan.Gem.Auction.Back.End.repository.AuctionRepository;
import com.madushan.Gem.Auction.Back.End.repository.UserRepository;
import com.madushan.Gem.Auction.Back.End.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;
    private final UserRepository userRepository;

    public Auction createAuction(Auction auction, String username) {
        User seller = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        auction.setSeller(seller);
        auction.setActive(true);
        return auctionRepository.save(auction);
    }

    public List<Auction> getAllActiveAuctions() {
        return auctionRepository.findByIsActiveTrue();
    }

    public Auction updateAuction(Long id, Auction updatedAuction, String username) {
        Auction auction = auctionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auction not found"));

        if (!auction.getSeller().getUsername().equals(username)) {
            throw new AccessDeniedException("You're not the owner of this auction");
        }

        auction.setTitle(updatedAuction.getTitle());
        auction.setDescription(updatedAuction.getDescription());
        auction.setStartingPrice(updatedAuction.getStartingPrice());
        auction.setEndTime(updatedAuction.getEndTime());

        return auctionRepository.save(auction);
    }

    public void deleteAuction(Long id, String username) {
        Auction auction = auctionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auction not found"));

        if (!auction.getSeller().getUsername().equals(username)) {
            throw new AccessDeniedException("You're not the owner of this auction");
        }

        auctionRepository.delete(auction);
    }
}
