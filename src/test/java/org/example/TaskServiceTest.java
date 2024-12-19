package org.example;

//Author: Christopher Rossi


import junit.framework.TestCase;

public class TaskServiceTest extends TestCase {

    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Name", "Description");
        service.addTask(task);
        assertEquals(task, service.getTask("123"));
    }

    public void testAddTaskDuplicateId() {
        TaskService service = new TaskService();
        Task task1 = new Task("123", "Name", "Description");
        Task task2 = new Task("123", "Another Task", "Another Description");
        service.addTask(task1);

        try {
            service.addTask(task2);
            fail("Expected IllegalArgumentException for duplicate task ID");
        } catch (IllegalArgumentException e) {

        }
    }

    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Name", "Description");
        service.addTask(task);
        service.deleteTask("123");
        assertNull(service.getTask("123"));
    }

    public void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Name", "Description");
        service.addTask(task);
        service.updateTaskName("123", "Updated Name");
        assertEquals("Updated Name", service.getTask("123").getName());
    }

    public void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Name", "Description");
        service.addTask(task);
        service.updateTaskDescription("12345", "Updated Description");
        assertEquals("Updated Description", service.getTask("123").getDescription());
    }
}
