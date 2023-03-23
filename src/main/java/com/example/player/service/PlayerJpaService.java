/*
 * You can use the following import statements
 */
package com.example.player.service;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
 import java.util.*;

import com.example.player.model.Player;
import com.example.player.repository.*;
  

// Write your code here
@Service
public class PlayerJpaService implements PlayerRepository {
    @Autowired
    public PlayerJpaRepository playerRepository;
    
    @Override
    public ArrayList<Player> getPlayers() {
        List<Player> playerList = playerRepository.findAll();
        ArrayList<Player> player = new ArrayList<>(playerList);
        return player;
    }

    @Override
    public Player getPlayerById(int playerId) {
        try {
            Player player = playerRepository.findById(playerId).get();
            return player;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }  
    
    @Override
    public Player updatePlayer(int playerId, Player player) {
        try {
            Player players = playerRepository.findById(playerId).get();
            if (player.getPlayerName() != null) {
                players.setPlayerName(player.getPlayerName());
            }
            if (player.getJerseyNumber() != 0) {
                players.setJerseyNumber(player.getJerseyNumber());
            }
            if (player.getRole() != null) {
                players.setRole(player.getRole());
            }
            return playerRepository.save(players);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePlayer(int playerId) {
        try {
            playerRepository.deleteById(playerId);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}