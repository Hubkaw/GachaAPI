package com.gachaapi.Repository;

import com.gachaapi.Entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
    List<Party> findAllByPlayer_IdPlayer(int id);
}
