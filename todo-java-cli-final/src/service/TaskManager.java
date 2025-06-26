package service;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Task;

import java.io.*;
import java.util.*;

public class TaskManager {
    private final String filepath;
    public final List<Task> tasks;

    public TaskManager(String filepath) {
        this.filepath = filepath;
        this.tasks = loadTasks();
    }

    private List<Task> loadTasks() {
        List<Task> list = new ArrayList<>();
        try {
            File file = new File(filepath);
            if (!file.exists()) return list;
            String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            JSONArray arr = new JSONArray(content);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                Task t = new Task(obj.getInt("id"), obj.getString("description"), obj.getString("category"));
                t.status = obj.getString("status");
                list.add(t);
            }
        } catch(Exception e) {
            System.out.println("Error reading tasks: " + e.getMessage());
        }
        return list;
    }

    private void saveTasks() {
        JSONArray arr = new JSONArray();
        for (Task t : tasks) {
            JSONObject o = new JSONObject();
            o.put("id", t.id);
            o.put("description", t.description);
            o.put("category", t.category);
            o.put("status", t.status);
            arr.put(o);
        }
        try(FileWriter w = new FileWriter(filepath)) {
            w.write(arr.toString(2));
        } catch(IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void addTask(String description, String category) {
        int id = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).id + 1;
        Task t = new Task(id, description, category);
        tasks.add(t);
        saveTasks();
        System.out.println("Added task #" + id);
    }

    public void listTasks() {
        if(tasks.isEmpty()) { System.out.println("No tasks found."); return; }
        for(Task t: tasks){
            System.out.printf("[%d] %s - %s (%s)%n", t.id, t.description, t.category, t.status);
        }
    }

    public void listTasksByCategory(String cat) {
        boolean found=false;
        for(Task t: tasks){
            if(t.category.equalsIgnoreCase(cat)){
                System.out.printf("[%d] %s - %s (%s)%n", t.id, t.description, t.category, t.status);
                found=true;
            }
        }
        if(!found) System.out.println("No tasks found in category: " + cat);
    }

    public void removeTask(int id){
        boolean removed = tasks.removeIf(t -> t.id == id);
        if(removed){ saveTasks(); System.out.println("Removed task #" + id);}
        else System.out.println("Task ID not found.");
    }

    public void markTaskAsCompleted(int id){
        for(Task t: tasks){
            if(t.id==id){
                t.status="Completed";
                saveTasks();
                System.out.println("Marked task #" + id + " as completed.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }
}
