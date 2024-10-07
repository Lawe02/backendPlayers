package org.example.crudboot;

import org.example.crudboot.Model.Player;
import org.example.crudboot.Service.ObjectService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    // Sort by goals
    @GetMapping("/players/sort/goals")
    public String sortByGoals(Model model) {
        model.addAttribute("players", service.sortPlayersByGoals()); // Add the sorted players list to the model
        return "index"; // Return the updated template
    }

    @GetMapping("/players/sort/position")
    public String sortByPosition(Model model) {
        model.addAttribute("players", service.sortPlayersByPosition());
        return "index";
    }

    @GetMapping("/players/sort/games")
    public String sortByGames(Model model) {
        model.addAttribute("players", service.sortPlayersByGames());
        return "index";
    }

}
