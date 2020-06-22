package xyz.breydan.lunar.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.breydan.lunar.model.LatestBlogpostModel;
import xyz.breydan.lunar.model.MetaModel;

import static xyz.breydan.lunar.util.Constants.*;

@RestController
public class MetadataController {

    private MetaModel meta = new MetaModel(AUTHOR, TITLE, CONTENT);

    @PostMapping("/meta")
    public LatestBlogpostModel getMetadata() {
        return new LatestBlogpostModel(meta);
    }

    @PostMapping("/setauthor")
    public void setAuthor(@RequestBody String s) {
        meta = new MetaModel(s, meta.getTitle(), meta.getContent());
        System.out.println(s);
    }

    @PostMapping("/settitle")
    public void setTitle(@RequestBody String s) {
        meta = new MetaModel(meta.getAuthor(), s, meta.getContent());
        System.out.println(s);
    }

    @PostMapping("/setcontent")
    public void setContent(@RequestBody String s) {
        meta = new MetaModel(meta.getAuthor(), meta.getTitle(), s);
        System.out.println(s);
    }
}
