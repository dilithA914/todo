package com.example.demo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.Todo;

// TODO: Auto-generated Javadoc
/**
 * The Interface TodoRepository.
 */
public interface TodoRepository extends MongoRepository<Todo, String>{
	
	/**
	 * Find by id.
	 *
	 * @param ObjectId the id
	 * @return the todo
	 */
	Todo findById(ObjectId id);

}
