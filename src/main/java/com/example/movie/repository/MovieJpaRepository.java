/*
 * You can use the following import statements
 * 
 * 
 * 
 */

// Write your code here

package com.example.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movie.model.*;

@Repository
public interface MovieJpaRepository extends JpaRepository<Movie, Integer> {}
