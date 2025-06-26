# 📋 Todo List CLI Application (Java)

A simple command-line Todo List app built in Java. It allows users to add, list, remove, complete, and filter tasks by category — all stored in a local JSON file.

---

## 🚀 Features

- ✅ Add new tasks with category
- 📄 List all tasks
- 📂 Filter tasks by category
- ✔️ Mark tasks as completed
- ❌ Remove tasks by ID
- 💾 Task persistence using JSON

---

## 📁 Project Structure

```
todo-java-cli-final/
├── src/
│   ├── model/Task.java
│   ├── service/TaskManager.java
│   └── Main.java
├── test/
│   └── TaskManagerTest.java
├── data/
│   └── tasks.json              # Seed data
│   └── test_tasks.json         # Auto-created during unit tests
├── lib/
│   ├── json.jar
│   ├── junit-4.13.2.jar
│   └── hamcrest-core-1.3.jar
├── bin/                        # Compiled class files
```

---

## 🧱 Requirements

- Java 8 or higher
- `json.jar` (for JSON parsing)
- `junit-4.13.2.jar` and `hamcrest-core-1.3.jar` for tests

Place all `.jar` files in the `lib/` directory.

---

## 🧪 Run the Application

### Compile:
```bash
javac -cp ".;lib/json.jar" -d bin src/model/*.java src/service/*.java src/Main.java
```

### Run:
```bash
java -cp ".;bin;lib/json.jar" Main
```

---

## 📌 Available CLI Commands

| Command         | Description                        |
|----------------|------------------------------------|
| `add`           | Add a task                         |
| `list`          | List all tasks                     |
| `list-category` | List tasks by category             |
| `complete`      | Mark a task as completed           |
| `remove`        | Remove a task by ID                |
| `exit`          | Exit the application               |

---

## ✅ Run Unit Tests

### Compile:
```bash
javac -cp ".;lib/*" -d bin src/model/*.java src/service/*.java src/Main.java test/*.java
```

### Execute:
```bash
java -cp ".;bin;lib/*" org.junit.runner.JUnitCore TaskManagerTest
```

You should see:

```
OK (5 tests)
```

---

## 🌱 Seed & Test Data

### Seed Data (`data/tasks.json`)
```json
[
  { "id": 1, "description": "Submit assignment", "category": "School", "status": "Pending" },
  { "id": 2, "description": "Buy groceries", "category": "Home", "status": "Pending" }
]
```

### Test Data (`data/test_tasks.json`)
Automatically created and reset by `TaskManagerTest.java` to ensure isolated and clean testing.

---

## 🔧 Future Enhancements

- Task prioritization and due dates
- GUI with JavaFX
- Export/import CSV or Excel
- SQLite integration for scalable storage

---

