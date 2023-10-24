package dev.stevim.NBA;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends MongoRepository<Team, ObjectId> {
    Optional<List<Team>> findAllByConference(String conference);
    Optional<List<Team>> findAllByDivision(String division);
    Optional<List<Team>> findAllByCity(String city);
    Optional<List<Team>> findAllByState(String state);
}
