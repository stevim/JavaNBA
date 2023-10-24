package dev.stevim.NBA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NBA TEAMS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    private ObjectId id;
    private String conference;
    private String division;
    private String name;
    private String city;
    private String state;
    private String stadium;
}
