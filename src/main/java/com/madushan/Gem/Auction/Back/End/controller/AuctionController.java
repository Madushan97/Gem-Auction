package com.madushan.Gem.Auction.Back.End.controller;

import com.madushan.Gem.Auction.Back.End.entity.Auction;
import com.madushan.Gem.Auction.Back.End.service.AuctionService;
import com.madushan.Gem.Auction.Back.End.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @PostMapping
    public ResponseEntity<StandardResponse> createAuction(@RequestBody Auction auction, Principal principal) {
        Auction createdAuction = auctionService.createAuction(auction, principal.getName());
        return new ResponseEntity<>(
          new StandardResponse(
                  HttpStatus.CREATED.value(),
                  "Auction created successfully",
                  createdAuction
          ),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllActiveAuctions() {
        List<Auction> auctions = auctionService.getAllActiveAuctions();
        return new ResponseEntity<>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Get all active auction successfully",
                        auctions
                ),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> updateAuction(@PathVariable Long id, @RequestBody Auction auction, Principal principal) {
        Auction updatedAuction = auctionService.updateAuction(id, auction, principal.getName());
        return new ResponseEntity<>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Update successfully",
                        updatedAuction
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteAuction(@PathVariable Long id, Principal principal) {
        auctionService.deleteAuction(id, principal.getName());
        return new ResponseEntity<>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Delete successfully",
                        null
                ),
                HttpStatus.OK
        );
    }
}
