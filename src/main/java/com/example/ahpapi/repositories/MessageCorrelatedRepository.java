package com.example.ahpapi.repositories;

import com.example.ahpapi.entities.Message;
import com.example.ahpapi.entities.MessageCorrelated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "correlatedMessages", path = "correlatedMessages")
public interface MessageCorrelatedRepository extends JpaRepository<MessageCorrelated, String> {

    @Query("SELECT m FROM MessageCorrelated m WHERE id IN (:mmIdList)")
    List<MessageCorrelated> findByMMIdList(@Param("mmIdList") List<Long> mmIdList);

}
