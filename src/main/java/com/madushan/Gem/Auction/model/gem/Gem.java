package com.madushan.Gem.Auction.model.gem;

import com.madushan.Gem.Auction.model.auction.Auction;
import jakarta.persistence.*;

@Table(name = "gems")
@Entity
public class Gem {

    private Integer id;
    private String gemType;
    private String color;
    private Boolean cut;
    private String transparency;
    private Auction auction;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "gem_type", nullable = false, length = 200)
    public String getGemType() {
        return gemType;
    }

    public void setGemType(String gemType) {
        this.gemType = gemType;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "cut")
    public Boolean getCut() {
        return cut;
    }

    public void setCut(Boolean cut) {
        this.cut = cut;
    }

    @Column(name = "transparency")
    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auction_id")
    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
