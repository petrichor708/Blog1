package com.lala.blog.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_comment")
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)//生成与数据库对应的时间格式(包括日期)
    private Date createTime;
    @ManyToOne()
    private Blog blog;
    //子评论
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments=new ArrayList<>();
    //父类
    @ManyToOne
    private Comment parentComment;

    private boolean adminComment;
}
