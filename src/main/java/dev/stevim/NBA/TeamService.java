package dev.stevim.NBA;

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
//    public Optional<Team> teamSimpleName(String simpleName) {
//        return teamRepository.findTeamBySimpleName(simpleName);
//    }
//    public Optional<Team> teamTeamName(String teamName) {
//        return teamRepository.findTeamByTeamName(teamName);
//    }
    public Optional<List<Team>> teamLocation(String location) {
        return teamRepository.findAllByLocation(location);
    }
}
