package com.example.fung_backend_repo.domain.feed.service;


import com.example.fung_backend_repo.domain.feed.domain.Feed;
import com.example.fung_backend_repo.domain.feed.domain.repository.FeedRepository;
import com.example.fung_backend_repo.domain.feed.exception.FeedCannotBeDeleteException;
import com.example.fung_backend_repo.domain.feed.facade.FeedFacade;
import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FeedDeleteService {
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final FeedRepository feedRepository;

    @Transactional
    public void execute(Long feedId){
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);

        if(!user.equals(feed.getUser())){
            throw FeedCannotBeDeleteException.EXCEPTION;
        }

        feedRepository.delete(feed);
    }
}
