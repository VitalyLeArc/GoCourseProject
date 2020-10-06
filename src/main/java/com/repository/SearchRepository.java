package com.repository;

import com.domain.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository <Search,Long> {
    List<Search> findAllByUserIdAndShowSimilarTrue(Long userId);
}
