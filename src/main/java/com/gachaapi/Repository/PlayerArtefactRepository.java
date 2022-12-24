package com.gachaapi.Repository;

import com.gachaapi.Entity.PlayerArtefact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerArtefactRepository extends JpaRepository<PlayerArtefact, Integer> {
    List<PlayerArtefact> findAllByPlayerNick(String nick);
}
