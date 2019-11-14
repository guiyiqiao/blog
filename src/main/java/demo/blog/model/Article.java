package demo.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String summary;
    private String content;
    private String category;
    private Date createDate;
    private Integer commentCount;
}
