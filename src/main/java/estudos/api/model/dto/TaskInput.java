package estudos.api.model.dto;

import estudos.api.model.Task;
import lombok.Data;

import java.util.Date;

@Data
public class TaskInput {
    private String name;
    private Boolean isFinished;
    private Date createdAt;
    private Date updatedAt;


}
