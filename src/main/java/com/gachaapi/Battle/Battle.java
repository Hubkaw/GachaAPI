package com.gachaapi.Battle;

import com.gachaapi.Entity.Party;
import lombok.Data;

import java.util.*;

import static com.gachaapi.Utils.Constants.*;

@Data
public class Battle {

    private PriorityQueue<BattleCharacter> queue;
    private int turn;
    private BattleParty attacker;
    private BattleParty defender;
    private String attackerName;
    private String defenderName;
    private List<BattleLogEntry> log;
    private String winner = null;

    private Battle(Party attacker, Party defender){
        this.attacker = new BattleParty(attacker, Side.ATTACKER);
        this.defender = new BattleParty(defender, Side.DEFENDER);
        attackerName = attacker.getPlayer().getNick();
        defenderName = defender.getPlayer().getNick();
        turn = 0;
        queue = new PriorityQueue<>();
        queue.addAll(this.attacker.getCharacters());
        queue.addAll(this.defender.getCharacters());
        log = new ArrayList<>();
        log(attackerName+"'s party "+attacker.getName()+" attacks party "+defender.getName()+".", EntryType.START, Side.SYSTEM);
    }


    public BattleLog start(){

        while (turn < 30){
            turn++;
            log("Turn "+turn+" started. "+attacker.getName()+" "+attacker.getHp()+" HP. "+defender.getName()+" "+defender.getHp()+" HP. ", EntryType.NEW_TURN, Side.SYSTEM);

            while (queue.peek()!=null){
                BattleCharacter currentCharacter = queue.poll();
                Side currentSide = currentCharacter.getSide();
                int POTATK = (currentCharacter.getBattleAbility().getPotency()/100)*currentCharacter.getStats().get(ATTACK_STAT);
                Map<String, Integer> stats = currentCharacter.getStats();
                String entryBeggining = currentCharacter.getName()+" uses "+currentCharacter.getBattleAbility().getName();
                switch (currentCharacter.getBattleAbility().getType()){

                    case ATTACK -> {

                        if (currentSide == Side.ATTACKER){
                            String message = defender.dealDamage(POTATK, stats.get(CRIT_RATE_STAT), stats.get(CRIT_DAMAGE_STAT));
                            log(entryBeggining+" to "+message+" to "+defender.getName()+". "+defender.getName()+" current hp is: "+defender.getHp()+".", EntryType.ATTACK, Side.ATTACKER);
                        } else {
                            String message = attacker.dealDamage(POTATK, stats.get(CRIT_RATE_STAT), stats.get(CRIT_DAMAGE_STAT));
                            log(entryBeggining+" to "+message+" to "+attacker.getName()+". "+attacker.getName()+" current hp is: "+attacker.getHp()+".", EntryType.ATTACK, Side.DEFENDER);
                        }

                        if (deathCheck())
                            return new BattleLog(log);
                    }
                    case BUFF -> {
                        if (currentSide == Side.ATTACKER){
                            String message = attacker.buff(POTATK, currentCharacter.getBattleAbility().getStat());
                            log(entryBeggining+" to "+message+".",EntryType.BUFF, Side.ATTACKER);
                        } else {
                            String message = defender.buff(POTATK, currentCharacter.getBattleAbility().getStat());
                            log(entryBeggining+" to "+message+".",EntryType.BUFF, Side.DEFENDER);
                        }
                        if (deathCheck())
                            return new BattleLog(log);
                    }
                    case DEBUFF -> {
                        if (currentSide == Side.DEFENDER){
                            String message = attacker.debuff(POTATK, currentCharacter.getBattleAbility().getStat());
                            log(entryBeggining+" to "+message+".",EntryType.DEBUFF, Side.DEFENDER);
                        } else {
                            String message = defender.debuff(POTATK, currentCharacter.getBattleAbility().getStat());
                            log(entryBeggining+" to "+message+".",EntryType.DEBUFF, Side.ATTACKER);
                        }
                        if (deathCheck())
                            return new BattleLog(log);
                    }
                    case HEAL -> {
                        if (currentSide == Side.ATTACKER){
                            String heal = attacker.heal(POTATK);
                            log(entryBeggining+" on "+attacker.getName()+" to "+heal+".", EntryType.HEAL, Side.ATTACKER);
                        } else {
                            String heal = defender.heal(POTATK);
                            log(entryBeggining+" on "+defender.getName()+" to "+heal+".", EntryType.HEAL, Side.DEFENDER);
                        }
                        if (deathCheck())
                            return new BattleLog(log);
                    }
                }
            }
            queue.addAll(this.attacker.getCharacters());
            queue.addAll(this.defender.getCharacters());
        }
        log("Defenders win by reaching turn limit.", EntryType.END, Side.SYSTEM);
        return new BattleLog(log);
    }


    private void log(String entry, EntryType type, Side side){
        log.add(new BattleLogEntry(entry, type, side));
    }

    private boolean deathCheck(){
        if (attacker.getHp()<=0){
            log(attackerName+" is defeated.", EntryType.LOSER,Side.SYSTEM);
            return true;
        } else if (defender.getHp()<=0){
            log(defender.getName()+" is defeated.", EntryType.WINNER,Side.SYSTEM);
            return true;
        } else {
            return false;
        }
    }


    public static BattleLog simulate(Party attacker, Party defender){
        return new Battle(attacker, defender).start();
    }
}
