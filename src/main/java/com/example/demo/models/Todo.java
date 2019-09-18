package com.example.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.*;


// TODO: Auto-generated Javadoc
/**
 * The Class Todo.
 */
public class Todo {
	
	/** id of the task mapped to mondodb document id as objectId. */
	@Id
	public ObjectId id;
	
	/** Topic of the task. */
	private String task;
	
	/** description. */
	private String text;
	
	/** date of the task */
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;
	
	/** time of the task */
	private LocalTime time;
	
	
	/**
	 * Instantiates a new todo.
	 *
	 * @param id the id
	 * @param task the task
	 * @param text the text
	 * @param date the date
	 * @param time the time
	 */
	public Todo( ObjectId id , String task , String text , LocalDate date , LocalTime time) {
		this.id = id;
		this.task = task;
		this.text = text;
		this.date = date;
		this.time = time;
		
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id as a string
	 */
	public String getId() {
		return id.toHexString();
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id 
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	/**
	 * Gets the task.
	 *
	 * @return the task as string
	 */
	public String getTask() {
		return task;
	}
	
	/**
	 * Sets the task.
	 *
	 * @param new task
	 */
	public void setTask(String task) {
		this.task = task;
	}
	
	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the text.
	 *
	 * @param new text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param new date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public LocalTime getTime() {
		return time;
	}
	
	/**
	 * Sets the time.
	 *
	 * @param new time
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
}
