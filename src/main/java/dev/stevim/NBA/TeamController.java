package dev.stevim.NBA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return new ResponseEntity<List<Team>>(teamService.allTeams(), HttpStatus.OK);
    }

//    @GetMapping("/{simpleName}")
//    public ResponseEntity<Optional<Team>> getTeamBySimpleName(@PathVariable String simpleName) {
//        return new ResponseEntity<Optional<Team>>(teamService.teamSimpleName(simpleName), HttpStatus.OK);
//    }

//    @GetMapping("/{fullName}")
//    public ResponseEntity<Optional<Team>> getTeamByFullName(@PathVariable String teamName) {
//        return new ResponseEntity<Optional<Team>>(teamService.teamTeamName(teamName), HttpStatus.OK);
//    }

    @GetMapping("/{location}")
    public ResponseEntity<Optional<List<Team>>> getTeamByLocation(@PathVariable String location) {
        return new ResponseEntity<Optional<List<Team>>>(teamService.teamLocation(location), HttpStatus.OK);
    }
}
