package com.gachaapi.Battle;

import com.gachaapi.Entity.Party;
import com.gachaapi.Entity.Player;
import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

import static com.gachaapi.Utils.Constants.DEFENCE_STAT;
import static com.gachaapi.Utils.Constants.HEALTH_STAT;

@Data
public class BattleParty {

    private Player player;
    private Set<BattleCharacter> characters;
    private int maxHp;
    private int hp;
    private int def;
    private String name;

    public BattleParty(Party party, Side side) {
        player = party.getPlayer();
        characters = new TreeSet<>();
        party.getCharacters().forEach(c -> characters.add(new BattleCharacter(c, side)));
        maxHp = 0;
        def = 0;
        name = party.getName();
        calculateDefences();

        hp = maxHp;
    }

    public String dealDamage(int a, int cr, int cd) {
        double damage;
        String message;
        if (a + def == 0)
            a++;
        if (Math.random() * 100 > cr) {
            damage = (double) a * ((double) a / (double) (def + a));
            message = "criticaly strike for " + (int)damage;
        } else {
            damage = ((double) a * ((double) cd) *  0.01) * ((double) a / (double) (def + a));
            message = "strike for " + (int)damage;
        }
        hp -= (int) damage;
        return message;
    }

    public String heal(int a){
        hp+= a;
        String message = "heal for "+ a;
        if (hp > maxHp) {
            hp = maxHp;
            message = message+" but their max HP is "+maxHp;
        }
        return message;
    }

    public void calculateDefences(){
        maxHp = 0;
        def = 0;
        characters.forEach(c -> {
            maxHp += c.getStats().get(HEALTH_STAT);
            def += c.getStats().get(DEFENCE_STAT);
        });
        if (hp>maxHp){
            hp = maxHp;
        }
    }

    public String buff(int a, String stat){

        String hpCase = "";
        if (stat.equals(HEALTH_STAT)){
            double ratio = (double) hp / (double) maxHp;
            hp = (int)(hp + (a * ratio));
            hpCase = " and raised current hp to "+hp;
        }

        characters.forEach(c -> {
            int newValue = c.getStats().get(stat) + a;
            c.getStats().put(stat, newValue);
        });
        if (stat.equals(HEALTH_STAT) || stat.equals(DEFENCE_STAT)){
            calculateDefences();
        }

        return "buff "+name+" characters' "+stat+" by "+a+hpCase;
    }

    public String debuff(int a, String stat){
        characters.forEach(c -> {
            int newValue = c.getStats().get(stat) - a;
            c.getStats().put(stat, newValue);
        });
        if (stat.equals(HEALTH_STAT) || stat.equals(DEFENCE_STAT)){
            calculateDefences();
        }
        return "debuff "+name+" characters' "+stat+" by "+a;
    }

}
