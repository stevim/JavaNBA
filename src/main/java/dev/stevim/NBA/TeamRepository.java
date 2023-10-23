package dev.stevim.NBA;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends MongoRepository<Team, ObjectId> {
//    Optional<Team> findTeamBySimpleName(String simpleName);
//    Optional<Team> findTeamByTeamName(String teamName);
    Optional<List<Team>> findAllByLocation(String location);
}
