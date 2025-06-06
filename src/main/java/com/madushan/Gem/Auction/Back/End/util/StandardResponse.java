package com.madushan.Gem.Auction.Back.End.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {

    private int statusCode;
    private String message;
    private Object data;
}
