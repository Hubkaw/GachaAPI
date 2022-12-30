package com.gachaapi.Battle;


import com.gachaapi.Entity.PlayerCharacter;
import com.gachaapi.Utils.AbilityType;
import lombok.Data;

import static com.gachaapi.Utils.Constants.NO_ELEMENT;

@Data
public class BattleAbility {
    private AbilityType type;
    private int potency;
    private String stat;
    private String name;
    private String element;

    public BattleAbility(PlayerCharacter character) {
        type = character.getCharacter().getAbility().getType();
        potency = character.getCharacter().getAbility().getPotency();
        name = character.getCharacter().getAbility().getName();

        if (type != AbilityType.ATTACK) {
            stat = character.getCharacter().getAbility().getStat().getShortName();
        }
        if (character.getWieldedWeapon() != null) {
            this.element = character.getWieldedWeapon().getWeapon().getElement().getName();
        } else {
            element = NO_ELEMENT;
        }
    }

}
