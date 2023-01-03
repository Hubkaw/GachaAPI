package com.gachaapi.Utils;

import com.gachaapi.Entity.Artefact;
import com.gachaapi.Entity.PlayerArtefact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterArtefacts {
    private PlayerArtefact glasses;
    private PlayerArtefact ring;
    private PlayerArtefact hat;
}
