package com.example.fung_backend_repo.domain.feed.domain.repository;

import com.example.fung_backend_repo.domain.feed.domain.Feed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedRepository extends CrudRepository<Feed, Long> {

    Optional<Feed> findById(Long feedId);
}
