package dev.stevim.NBA;

import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, ObjectId> {
    Optional<List<Player>> findAllByFirstNameContaining(String firstName);
    Optional<Player> findByPlayerId(Integer playerId);
    boolean existsByPlayerId(Integer playerId);
    void deleteByPlayerId(Integer playerId);

}
