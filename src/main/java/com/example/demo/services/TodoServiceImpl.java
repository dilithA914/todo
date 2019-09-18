package com.example.demo.services;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Todo;
import com.example.demo.repositories.TodoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class TodoServiceImpl.
 */


@Service
public class TodoServiceImpl implements TodoService{
	
	/** The repository object. */
	@Autowired
	private TodoRepository repository;
	
	/**
	 * Creates the todo task and store it in the db.
	 *
	 * @param a new Todo object as newTodo
	 * @return stored todo object
	 */
	@Override
	public Todo createTask(Todo newTodo) {
		
		//Assign a ObjectId to the newTodo object
		newTodo.setId(ObjectId.get());	
		
		repository.save(newTodo);
		return newTodo;
	}
	
	/**
	 * View all tasks stored in the db.
	 *
	 * @return all todo documents in the db as an ArrayList
	 */
	@Override
	public ArrayList<Todo> viewAllTasks() {
		return (ArrayList<Todo>) repository.findAll();
	}
	
	/**
	 * View an individual task by the given id.
	 *
	 * @param objectId of the desired task
	 * @return all the contents of the task
	 */
	@Override
	public Todo viewById(ObjectId id) {
		return repository.findById(id);
	}


	/**
	 * Delete task from db by the given ObjectId.
	 *
	 * @param ObjectId of the task that needs to be deleted
	 */
	@Override
	public void deleteTask(ObjectId id) {
		
		//finds which document contain the given id and remove the whole document
		repository.delete(repository.findById(id));
		
	}

	/**
	 * Update contents of a task by the given id.
	 *
	 * @param ObjectId of the task
	 * @param new contents for the task 
	 */
	@Override
	public void updateTask(ObjectId id, Todo updateTodo) {
		updateTodo.setId(id);
		repository.save(updateTodo);
		
	}

}
