package com.example.learning_english.repository;

import com.example.learning_english.entity.Exercise;
import com.example.learning_english.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Page<Question> findAll(Pageable pageable);
    Page<Question> findAllByExercise_idOrderByAnswersAsc(Pageable pageable,int id);

}
