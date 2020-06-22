package xyz.breydan.lunar.model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class LatestBlogpostModel {

    private final MetaModel latest_blog_post;
    private final boolean banned = false;
    private final Set<String> channels = new HashSet<>();

    public LatestBlogpostModel(MetaModel latest_blog_post) {
        this.latest_blog_post = latest_blog_post;
        channels.add("1.7.10");
        channels.add("1.8.9");
    }
}
