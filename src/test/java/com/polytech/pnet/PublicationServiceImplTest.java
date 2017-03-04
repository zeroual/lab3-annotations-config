package com.polytech.pnet;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class PublicationServiceImplTest {

    @Test
    public void shouldAddPost() {
        System.setProperty("spring.profiles.active","DEV");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PublicationService publicationService = applicationContext.getBean(PublicationService.class);

        publicationService.post(new Post("Hi Polytech"));

        PostRepository postRepository = applicationContext.getBean(PostRepository.class);

        List<Post> allPost = postRepository.findAll();
        Assertions.assertThat(allPost).hasSize(1);
        Assertions.assertThat(allPost.get(0).getContent()).isEqualTo("Hi Polytech");

    }

}