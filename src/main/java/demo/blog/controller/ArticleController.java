package demo.blog.controller;

import demo.blog.model.Article;
import demo.blog.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @PostMapping("/article")
    public Result addArticle(@RequestBody Article article){
        System.out.println("save article");
        return null;
    }
}
