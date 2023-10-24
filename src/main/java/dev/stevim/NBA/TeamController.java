package dev.stevim.NBA;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return new ResponseEntity<List<Team>>(teamService.allTeams(), HttpStatus.OK);
    }
    @GetMapping("/index/conference/{conference}")
    public ResponseEntity<Optional<List<Team>>> getConference(@PathVariable String conference) {
        return new ResponseEntity<Optional<List<Team>>>(teamService.teamByConference(conference), HttpStatus.OK);
    }
    @GetMapping("/index/division")
    public ResponseEntity<Optional<List<Team>>> getDivision(@PathVariable String division) {
        return new ResponseEntity<Optional<List<Team>>>(teamService.teamByDivision(division), HttpStatus.OK);
    }
    @GetMapping("/index/{city}")
    public ResponseEntity<Optional<List<Team>>> getCity(@PathVariable String city) {
        return new ResponseEntity<Optional<List<Team>>>(teamService.teamByCity(city), HttpStatus.OK);
    }
    @GetMapping("/index/state/{state}")
    public ResponseEntity<Optional<List<Team>>> getState(@PathVariable String state) {
        return new ResponseEntity<Optional<List<Team>>>(teamService.teamByState(state), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{_id}")
    public void deleteTeam(@PathVariable ObjectId _id) {
        teamService.deleteTeam(_id);
    }
}
