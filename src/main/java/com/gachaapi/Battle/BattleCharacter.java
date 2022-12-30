package com.gachaapi.Battle;

import com.gachaapi.Entity.PlayerCharacter;
import com.gachaapi.Entity.Set;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import static com.gachaapi.Utils.Constants.*;
import static java.util.Arrays.asList;

@Data
public class BattleCharacter implements Comparable<BattleCharacter>{

    private String name;
    private int lvl;
    private Map<String, Integer> stats;
    private BattleAbility battleAbility;
    private Side side;

    public BattleCharacter(PlayerCharacter character, Side side){
        lvl = character.getLvl();
        stats = new HashMap<>();
        name = character.getCharacter().getName();
        this.side = side;

        character.getCharacter().getCharacterClass().getStats().forEach(sc -> {
            changeStat(sc.getStat().getShortName(), sc.getValue() * character.getLvl());
        });

        if (character.getWieldedWeapon() != null) {
            character.getWieldedWeapon().getWeapon().getStats().forEach(ws -> {
                changeStat(ws.getStat().getShortName(), ws.getValue() * character.getWieldedWeapon().getLvl());
            });
        }

        if (character.getPlayerArtefacts() != null && !character.getPlayerArtefacts().isEmpty()) {
            Map<Set, Boolean> setCheck = new HashMap<>();
            character.getPlayerArtefacts().forEach(pa -> {
                pa.getArtefact().getSets().forEach(set -> {
                    setCheck.put(set, true);
                });
            });

            character.getPlayerArtefacts().forEach(a -> {
                a.getArtefact().getStatArtifacts().forEach(statArtifact -> {
                    changeStat(statArtifact.getStats().getShortName(), statArtifact.getValue() * a.getLvl());
                });
                setCheck.forEach((set, value) -> {
                    if (!a.getArtefact().getSets().contains(set)){
                        setCheck.put(set, false);
                    }
                });
            });
            setCheck.forEach((set, check) -> {
                if (check){
                    set.getStats().forEach(statArtefactSet -> changeStat(statArtefactSet.getStat().getShortName(), statArtefactSet.getValue()));
                }
            });
        }

        asList(INITIATIVE_STAT, ATTACK_STAT, HEALTH_STAT, CRIT_DAMAGE_STAT, CRIT_RATE_STAT, DEFENCE_STAT).forEach( s ->{
            if (!stats.containsKey(s)){
                stats.put(s,0);
            }
        });

        battleAbility = new BattleAbility(character);
    }


    protected void changeStat(String name, int value){
        if (stats.containsKey(name)){
            stats.put(name, stats.get(name) + value);
        } else {
            stats.put(name, value);
        }
    }


    @Override
    public int compareTo(BattleCharacter o) {
        int result = stats.get(INITIATIVE_STAT).compareTo(o.getStats().get(INITIATIVE_STAT)) * -1;
        if (result !=0)
            return result;
        return name.compareTo(o.getName());
    }
}
