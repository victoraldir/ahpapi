package com.example.ahpapi.repositories;

import com.example.ahpapi.entities.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Page<Message> findByTailNumber(@Param("tailNumber") String tailNumber, Pageable Pageable);

    Page<Message> findAll(Pageable Pageable);

    @Query("SELECT m.tailNumber FROM Message m GROUP BY m.tailNumber")
    List<String> findTailNumbers();

}
