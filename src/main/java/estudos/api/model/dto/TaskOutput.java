package estudos.api.model.dto;

import estudos.api.model.Task;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskOutput {
    private Integer id;

    private String name;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isFinished;


    public TaskOutput converter(Task task){
        return new TaskOutput(task.getId(), task.getName(),
                task.getCreatedAt(), task.getUpdatedAt(), task.getIsFinished());
    }
}
