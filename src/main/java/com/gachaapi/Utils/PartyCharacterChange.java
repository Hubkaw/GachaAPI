package com.gachaapi.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyCharacterChange {
private int oldCharacterId;
private int partyId;
private int characterId;
}
