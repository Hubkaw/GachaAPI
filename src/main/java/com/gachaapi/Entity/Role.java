package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int Id;

    @Basic
    @Column(name = "Name", unique = true, nullable = false, length = 16)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Player_Role",
            joinColumns = {
                    @JoinColumn(name = "Role_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Player_Player_Id")
            })
    @JsonIgnore
    private Set<Player> players;

}
