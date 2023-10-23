package dev.stevim.NBA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NBA Teams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    private ObjectId id;
    private Integer teamId;
    private String abbreviation;
    private String teamName;
    private String simpleName;
    private String location;

}
