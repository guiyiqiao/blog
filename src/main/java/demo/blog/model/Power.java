package demo.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Power implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Integer id;
    private String power;

}
