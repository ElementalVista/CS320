package org.example;

// Author: Christopher Rossi

import junit.framework.TestCase;

public class TaskTest extends TestCase {

    // Test for valid task creation
    public void testTaskCreationValid() {
        Task task = new Task("12345", "Task Name", "Task Description");
        assertEquals("12345", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    // Test for invalid task ID
    public void testTaskCreationInvalidId() {
        // Test for null task ID
        try {
            new Task(null, "Name", "Description");
            fail("Expected IllegalArgumentException for null task ID");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test for task ID exceeding 10 characters
        try {
            new Task("12345678901", "Name", "Description");
            fail("Expected IllegalArgumentException for task ID exceeding 10 characters");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    // Test for valid task name set
    public void testTaskSetNameValid() {
        Task task = new Task("12345", "Task Name", "Task Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    // Test for invalid task name set
    public void testTaskSetNameInvalid() {
        Task task = new Task("12345", "Task Name", "Task Description");

        // Test for null name
        try {
            task.setName(null);
            fail("Expected IllegalArgumentException for null name");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test for name exceeding 20 characters
        try {
            task.setName("Name exceeding twenty characters");
            fail("Expected IllegalArgumentException for name exceeding 20 characters");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    // Test for valid task description set
    public void testTaskSetDescriptionValid() {
        Task task = new Task("12345", "Task Name", "Task Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    // Test for invalid task description set
    public void testTaskSetDescriptionInvalid() {
        Task task = new Task("12345", "Task Name", "Task Description");

        // Test for null description
        try {
            task.setDescription(null);
            fail("Expected IllegalArgumentException for null description");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        // Test for description exceeding 50 characters
        try {
            task.setDescription("Description exceeding fifty characters is not allowed");
            fail("Expected IllegalArgumentException for description exceeding 50 characters");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    // Additional test for description longer than 30 characters during task creation
    public void testDescriptionLongerThan30Characters() {
        try {
            new Task("0123456789", "Test Task", "This is a test task with an extra extra long description");
            fail("Expected IllegalArgumentException for description exceeding 30 characters");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    // Additional test for null description during task creation
    public void testDescriptionNull() {
        try {
            new Task("0123456789", "Test Task", null);
            fail("Expected IllegalArgumentException for null description");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    // Additional test for name longer than 20 characters during task creation
    public void testNameLongerThan20Characters() {
        try {
            new Task("0123456789", "This is a name that exceeds twenty characters", "Description");
            fail("Expected IllegalArgumentException for name exceeding 20 characters");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}