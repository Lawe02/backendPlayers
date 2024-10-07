package org.example.crudboot;

import org.example.crudboot.Model.Player;
import org.example.crudboot.Service.ObjectService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private ObjectService service;

    public Controller(ObjectService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAllPlayers(Model model) {
        List<Player> players = service.getAllPlayers(); // Get the list of players
        model.addAttribute("players", players); // Add the players list to the model
        return "index"; // Return the name of the Thymeleaf template (players.html)
    }

}
