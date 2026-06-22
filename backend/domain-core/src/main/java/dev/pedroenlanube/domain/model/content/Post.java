package dev.pedroenlanube.domain.model.content;

import dev.pedroenlanube.domain.model.content.vo.MultimediaResource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private String id;
    private String creatorId;
    private String title;
    private String text;
    private MultimediaResource resource;
    private String subscriptionLevelRequired;
    private PostState state;
    private Instant creationDate;

    public Post(String id, String creatorId, String title) {
        this.id = Objects.requireNonNull(id, "The post ID is mandatory");
        this.creatorId = Objects.requireNonNull(creatorId, "The creator ID is mandatory");
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("The title is mandatory");
        }
        this.title = title;
        this.text = "";
        this.resource = null;
        this.state = PostState.DRAFT;
        this.creationDate = null;
    }

    public void attachResource(MultimediaResource resource) {
        if(this.state.equals(PostState.ARCHIVED)) {
            throw new IllegalStateException("The resource cannot be attached to an archived post");
        }
        this.resource = Objects.requireNonNull(resource, "The resource is mandatory");
    }

    public void publish(String text) {
        if(this.state.equals(PostState.PUBLISHED))
            throw new IllegalStateException("The post is already published");
        this.text = Objects.requireNonNull(text, "The text is mandatory");
        this.state = PostState.PUBLISHED;
        this.creationDate = Instant.now();
    }
}
