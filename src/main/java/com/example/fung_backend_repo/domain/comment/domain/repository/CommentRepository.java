package com.example.fung_backend_repo.domain.comment.domain.repository;

import com.example.fung_backend_repo.domain.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    Optional<Comment> findById(Long id);

    List<Comment> findByFeedId(Long feedId);
}
