package com.madushan.Gem.Auction.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Table(name = "auction")
@Entity
public class Auction {

    private Integer id;
    private String auctionName;
    private Date startTime;
    private Date endTime;
    private Set<Gem> gems;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "auction_name", nullable = false, length = 250)
    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    @Column(name = "start_time", nullable = false)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name = "end_time", nullable = false)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "auction")
    public Set<Gem> getGems() {
        return gems;
    }

    public void setGems(Set<Gem> gems) {
        this.gems = gems;
    }

    @ManyToMany
    @JoinTable(
            name = "auction_user",
            joinColumns = @JoinColumn(name = "auction_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
