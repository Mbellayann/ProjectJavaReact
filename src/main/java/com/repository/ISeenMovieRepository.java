package com.repository;

import com.datamodel.SeenMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeenMovieRepository extends JpaRepository<SeenMovie, Long> {
}
