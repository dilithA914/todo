package com.example.demo.services;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.demo.models.Todo;

// TODO: Auto-generated Javadoc
/**
 * The Interface TodoService.
 */
public interface TodoService {
	
	/**
	 * Creates the todo task
	 */
	public abstract Todo createTask(Todo newTodo);
	
	/**
	 * View all todo tasks.
	 */
	public abstract List<Todo> viewAllTasks();
	
	/**
	 * View Tasks by given id
	 */
	public abstract Todo viewById(ObjectId id);
	
	/**
	 * Delete todo tasks from db by the given id.
	 */
	public abstract void deleteTask(ObjectId id);
	
	/**
	 * Update contents of task by the given id.
	 * 
	 */
	public abstract void updateTask(ObjectId id , Todo updateTodo);

}
