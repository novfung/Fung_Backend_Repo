package com.example.fung_backend_repo.domain.feed.facade;


import com.example.fung_backend_repo.domain.feed.domain.Feed;
import com.example.fung_backend_repo.domain.feed.domain.repository.FeedRepository;
import com.example.fung_backend_repo.domain.feed.exception.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedFacade {
    private final FeedRepository feedRepository;

    public Feed getFeedById(Long id){
        return feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }
}
