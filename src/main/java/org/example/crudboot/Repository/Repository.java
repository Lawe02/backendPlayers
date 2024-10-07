package org.example.crudboot.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.crudboot.Model.Player;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.io.InputStream;

@Component
public class Repository {
    private List<Player> players;

    public Repository(){
        readPlayers();
    }

    public void readPlayers(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream inputStream = Player.class.getClassLoader().getResourceAsStream("players.json");

            if (inputStream == null) {
                throw new IllegalArgumentException("File not found in resources: persons.json");
            }

            players = mapper.readValue(inputStream, new TypeReference<List<Player>>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
