package com.example.fung_backend_repo.domain.feed.service;


import com.example.fung_backend_repo.domain.feed.domain.Feed;
import com.example.fung_backend_repo.domain.feed.exception.FeedCannotBeModifyException;
import com.example.fung_backend_repo.domain.feed.facade.FeedFacade;
import com.example.fung_backend_repo.domain.feed.presentation.dto.request.FeedUpdateRequest;
import com.example.fung_backend_repo.domain.user.domain.User;
import com.example.fung_backend_repo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FeedUpdateService {
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void execute(Long feedId, FeedUpdateRequest feedUpdateRequest) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);

        if(!user.equals(feed.getUser())){
            throw FeedCannotBeModifyException.EXCEPTION;
        }
        feed.feedUpdate(feedUpdateRequest.getTitle(), feedUpdateRequest.getContent(), feedUpdateRequest.getImage_url());
    }
}
