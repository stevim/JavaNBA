package dev.stevim.NBA;

import com.github.fge.jsonpatch.JsonPatch;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity<List<Player>>(playerService.allPlayers(), HttpStatus.OK);
    }
    @GetMapping("/{playerId}")
    public ResponseEntity<Optional<Player>> getPlayerId(@PathVariable Integer playerId) {
        return new ResponseEntity<Optional<Player>>(playerService.getPlayer(playerId), HttpStatus.OK);
    }
    @GetMapping("/names/{firstName}")
    public ResponseEntity<Optional<List<Player>>> getPlayerFirstName(@PathVariable String firstName) {
        return new ResponseEntity<Optional<List<Player>>>(playerService.playerFirstName(firstName), HttpStatus.OK);
    }
    @PostMapping("/new")
    public void addPlayer(@RequestBody Player player) {
        playerService.createPlayer(player);
    }
    @PatchMapping(path = "/edit/{playerId}")
    public ResponseEntity<Player> patchPlayer(@PathVariable Integer playerId, @RequestBody Player playerRequest) {
        Optional<Player> player = playerService.getPlayer(playerId);
        if (player.isPresent()) {
            player.get().setTeamId(playerRequest.getTeamId());
            Player updatedPlayer = playerService.savePlayer(player.get());
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return null;
        }
    }
    @DeleteMapping(path = "{playerId}")
    public void deletePlayer(@PathVariable("playerId") Integer playerId) {
        playerService.deletePlayer(playerId);
    }
}