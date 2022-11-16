package com.gachaapi.Security.Service;

import com.gachaapi.Repository.PlayerRepository;
import com.gachaapi.Security.Config.GachaUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class GachaUserDetailsService implements UserDetailsService {

    private static final String usernameNotFoundMessage = "Username not found";

    PlayerRepository playerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new GachaUserDetails(
                playerRepository.findByNick(username)
                        .orElseThrow(() ->
                                new UsernameNotFoundException(usernameNotFoundMessage)));
    }
}
