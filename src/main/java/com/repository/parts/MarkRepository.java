package com.repository.parts;

import com.domain.parts.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository <Mark,Long>{
    List<Mark> findAll();
    void deleteAll();

}
