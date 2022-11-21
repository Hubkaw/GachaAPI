package com.gachaapi.Utils.dev;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
public class NewChest {
    private String name;
    private Date releasedAt;
    private Date expiresAt;
    private int collectionId;
    private int price;


}
