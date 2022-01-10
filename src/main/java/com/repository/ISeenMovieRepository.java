package com.repository;

import com.datamodel.SeenMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ISeenMovieRepository extends JpaRepository<SeenMovie, Long> {
    public SeenMovie findByDateSeen(Date dateSeen);
}
