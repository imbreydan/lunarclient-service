package xyz.breydan.lunar.model;

import lombok.Getter;
import xyz.breydan.lunar.util.Util;

@Getter
public class MetaModel {

    private String author, author_uuid, title, content;

    public MetaModel(String author, String title, String content) {
        this.author = author;
        this.author_uuid = Util.uuidFromName(author).toString();
        this.title = title;
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
        author_uuid = Util.uuidFromName(author).toString();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
