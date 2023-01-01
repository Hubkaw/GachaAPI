package com.gachaapi.Utils.dev;

import com.gachaapi.Entity.Dungeon;
import com.gachaapi.Utils.DungeonType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class NewDungeon {

    private String name;
    private Date releasedAt;
    private Date expiresAt;
    private DungeonType type;

    public Dungeon create(){
        Dungeon newDungeon=new Dungeon();
        newDungeon.setName(name);
        newDungeon.setReleasedAt(new Timestamp(releasedAt.getTime()));
        newDungeon.setExpiresAt(new Timestamp(expiresAt.getTime()));
        newDungeon.setType(type);
        return newDungeon;
    }
}
