package org.example.crudboot.Service;

import org.example.crudboot.Model.Player;
import org.example.crudboot.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ObjectService {
    private Repository repo;
    public ObjectService(Repository repo) {
        this.repo = repo;
    }

    public List<Player> getAllPlayers() {
        return repo.getPlayers();
    }

    public List<Player> sortPlayersByGoals() {
        return getAllPlayers().stream()
                .sorted(Comparator.comparing(Player::getGoals).reversed())
                .toList();
    }

    public List<Player> sortPlayersByPosition() {
        return getAllPlayers().stream()
                .sorted(Comparator.comparing(Player::getPosition))
                .toList();
    }
}
