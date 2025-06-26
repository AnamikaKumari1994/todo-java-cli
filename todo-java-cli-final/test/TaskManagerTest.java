
import org.junit.Before;
import org.junit.Test;

import model.Task;
import service.TaskManager;

import java.io.File;
import java.util.List;
import static org.junit.Assert.*;

public class TaskManagerTest {
    private TaskManager manager;
    private final String path = "data/test_tasks.json";
    

    @Before
    public void setup(){
        File f = new File(path);
        if(f.exists()) f.delete();
        manager = new TaskManager(path);
    }
    @Test
     public void testempty(){
        System.out.println("testing test empty");
        manager.listTasks();

        assertTrue(manager.tasks.isEmpty());
     }
    @Test
    public void testAdd(){
        manager.addTask("Test", "Dev");
        List<Task> tasks = manager.tasks;
        assertEquals(1, tasks.size());
        assertEquals("Test", tasks.get(0).description);
    }

    @Test
    public void testRemove(){
        manager.addTask("Temp", "Dev");
        int id = manager.tasks.get(0).id;
        manager.removeTask(id);
        assertTrue(manager.tasks.isEmpty());
    }

    @Test
    public void testComplete(){
        manager.addTask("Done", "Work");
        int id = manager.tasks.get(0).id;
        manager.markTaskAsCompleted(id);
        assertEquals("Completed", manager.tasks.get(0).status);
    }

    @Test
    public void testFilter(){
        manager.addTask("A", "X");
        manager.addTask("B", "Y");
        manager.addTask("C", "X");
        long count = manager.tasks.stream().filter(t -> t.category.equalsIgnoreCase("X")).count();
        assertEquals(2, count);
    }
}
