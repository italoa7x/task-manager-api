package estudos.api.services;

import estudos.api.model.Task;
import estudos.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;


    public Task createTask(Task task){
        task.setCreatedAt(new Date());
        task.setUpdatedAt(new Date());
        task.setFinished(false);
        return this.repository.save(task);
    }


    public List<Task> getAll(){
        return this.repository.findAll();
    }

    public Task findTaskById(Integer id){
        var task = this.repository.findById(id);

        if(task.isEmpty()){
            return null;
        }
        return task.get();
    }


    public Task updateTask(Integer taskId, Task newTask){

        var oldTask = this.repository.findById(taskId);

        if(oldTask.isEmpty()){
            return null;
        }

        var taskValue = oldTask.get();

        taskValue.setUpdatedAt(new Date());

        taskValue.setName(newTask.getName());

        taskValue.setFinished(false);

        return this.repository.save(taskValue);
    }

    public void finishTask(Integer taskId){
        var task = this.repository.findById(taskId);
        if(!task.isEmpty()){
            var taskValue = task.get();

            taskValue.setFinished(true);
            this.repository.save(taskValue);
        }
    }

}
