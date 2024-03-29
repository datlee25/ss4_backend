package com.example.learning_english.repository;

import com.example.learning_english.entity.Blog;
import com.example.learning_english.entity.Course;
import com.example.learning_english.entity.User;
import com.example.learning_english.entity.UserScore;
import com.example.learning_english.specifications.SearchSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScore,Integer>, JpaSpecificationExecutor<UserScore> {
    Page<UserScore> findAll(Pageable pageable);
    Optional<UserScore> findUserScoreByUserId(int id);
    List<UserScore> findAll();

    List<UserScore> findByUserId(int userId);
}