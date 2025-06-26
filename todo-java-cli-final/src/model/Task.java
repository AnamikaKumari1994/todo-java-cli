package model;

public class Task {
    public int id;
    public String description;
    public String category;
    public String status;

    public Task(int id, String description, String category) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.status = "Pending";
    }
}
