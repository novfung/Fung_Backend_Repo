package com.example.fung_backend_repo.domain.feed.service;


import com.example.fung_backend_repo.domain.feed.domain.Feed;
import com.example.fung_backend_repo.domain.feed.domain.repository.FeedRepository;
import com.example.fung_backend_repo.domain.feed.presentation.request.FeedCreateRequest;
import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FeedCreateService {
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void  execute(FeedCreateRequest feedCreateRequest){
        User user = userFacade.getCurrentUser();
        Feed feed = feedRepository.save(
                Feed.builder()
                        .title(feedCreateRequest.getTitle())
                        .content(feedCreateRequest.getContent())
                        .imageUrl(feedCreateRequest.getImage_url())
                        .build()
        );
    }
}
