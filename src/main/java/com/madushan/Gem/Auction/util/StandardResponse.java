package com.madushan.Gem.Auction.util;

import lombok.Data;

@Data
public class StandardResponse<T> {
    private int status;
    private String message;
    private T data;

    public StandardResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
