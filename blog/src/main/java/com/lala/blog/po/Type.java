package com.lala.blog.po;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_type ")
@Data
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message="分类名称不能为空")
    private String name;

    @OneToMany(mappedBy = "type")//被维护端
    private List<Blog> blogs=new ArrayList<>();
}
