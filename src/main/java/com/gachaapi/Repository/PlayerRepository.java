package com.gachaapi.Repository;


import com.gachaapi.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PlayerRepository extends JpaRepository<Player, Long> {

}
