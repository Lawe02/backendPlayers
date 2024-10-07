package org.example.crudboot.Repository;

import org.example.crudboot.Model.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void readPlayers() {
        Repository repo = new Repository();
        List<Player> players = repo.getPlayers();
        assertNotNull(players);
    }

}