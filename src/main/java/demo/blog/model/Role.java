package demo.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer id;
    private String roleName;

    private List<Power> powers;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
