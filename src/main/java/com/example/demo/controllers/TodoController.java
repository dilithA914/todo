package com.example.demo.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Todo;
import com.example.demo.services.TodoServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class TodoController.
 */
@RestController
@RequestMapping("/todo")
public class TodoController {
	
	/** The todo service. */
	@Autowired
	TodoServiceImpl todoService;
	

	/**
	 * returns user details by the spring security header.
	 * @return the principal
	 */
	@GetMapping("/userDetails")
	   public Principal user(Principal principal) {
	      return principal;
	   }
	
	
	/**
	 * Adds the task.
	 *
	 * @param new Todo 
	 * @return newTodo inside the response entity body
	 */
	@PostMapping("/addTask")
	public ResponseEntity<Object> addTask(@Valid @RequestBody Todo newTodo) {
		return new ResponseEntity<>(todoService.createTask(newTodo), HttpStatus.CREATED);		
	}		
	
	
	/**
	 * View all tasks.
	 *
	 * @return all tasks inside the response entity body
	 */
	@GetMapping("/viewAllTasks")
	public ResponseEntity<Object> viewAllTasks(){			
		return new ResponseEntity<>(todoService.viewAllTasks(), HttpStatus.OK);
	}
	
	/**
	 * View task by id.
	 *
	 * @param objectId of the desired task
	 * @return task inside the response entity body
	 */
	@GetMapping("/viewTask/{id}")
	public ResponseEntity<Object> viewTaskById(@PathVariable("id") ObjectId id){
		return new ResponseEntity<>(todoService.viewById(id), HttpStatus.OK);
	}
	
	
	/**
	 * Delete task.
	 *
	 * @param objectId of the task to be deleted
	 * @return the response entity
	 */
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<Object> deleteTask(@PathVariable("id") ObjectId id){		
		todoService.deleteTask(id);
		return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);				
	}
	
	/**
	 * Update task.
	 *
	 * @param ObjectId of the task that needs to be updated
	 * @param new task content inside updateTodo 
	 * @return the response entity
	 */
	@PutMapping("/updateTask/{id}")
	public ResponseEntity<Object> updateTask(@Valid @PathVariable("id") ObjectId id , @RequestBody Todo updateTodo){
		todoService.updateTask(id,updateTodo);
		return new ResponseEntity<>("Task Updated successfully", HttpStatus.OK);	
	}
	
	
}






