package hexlet.code.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.Set;

@Getter
@Setter
public class TaskUpdateDTO {
    @JsonProperty("assignee_id")
    private JsonNullable<Long> assigneeId;

    private JsonNullable<Integer> index;

    @Size(min = 1)
    private JsonNullable<String> title;

    private JsonNullable<String> content;

    private JsonNullable<String> status;

    private JsonNullable<Set<Long>> taskLabelIds;
}
