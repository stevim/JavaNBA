package dev.stevim.NBA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "NBA Players 2021")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private Integer playerId;
    private Integer teamId;
}
