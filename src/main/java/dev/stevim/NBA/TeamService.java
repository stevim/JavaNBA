package dev.stevim.NBA;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public List<Team> allTeams() {
        return teamRepository.findAll();
    }
    public Optional<List<Team>> teamByConference(String conference) {
        return teamRepository.findAllByConference(conference);
    }
    public Optional<List<Team>> teamByDivision(String division) {
        return teamRepository.findAllByDivision(division);
    }
    public Optional<List<Team>> teamByCity(String city) {
        return teamRepository.findAllByCity(city);
    }
    public Optional<List<Team>> teamByState(String state) {
        return teamRepository.findAllByState(state);
    }
    public void deleteTeam(ObjectId id) {
        boolean exists = teamRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Team does not exist");
        }
        teamRepository.deleteById(id);
    }
}
