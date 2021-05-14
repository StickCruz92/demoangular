/**
 * 
 */
package com.example.demoangular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demoangular.modelo.User;


/**
 * @author stick.stivenson
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String name);
}
