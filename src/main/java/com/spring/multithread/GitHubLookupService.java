package com.spring.multithread;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * Created by adnenehamdouni on 19/07/2018.
 */

@Service
@Slf4j // <--- THIS use LOMBOK to generate Logger
public class GitHubLookupService {

    /*
    * USE LOG FROM LOMBOK
    * PS: We can use also Logger
    * private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);
    * logger.info("Looking up " + user);
     */

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException {

        log.info("testing logging with lombok");
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }
}
