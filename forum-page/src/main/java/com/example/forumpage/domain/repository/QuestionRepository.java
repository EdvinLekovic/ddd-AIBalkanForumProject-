package com.example.forumpage.domain.repository;

import com.example.forumpage.domain.models.Question;
import com.example.forumpage.domain.models.ids.QuestionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, QuestionId> {
}
