package com.gachaapi.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangeArtefact {
    private int characterId;
    private int oldArtefactId;
    private int artefactId;
}
