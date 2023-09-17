package com.erdog.developerblogbackend.model;

import com.erdog.developerblogbackend.model.base.BaseModel;
import com.erdog.developerblogbackend.model.enums.PostStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseModel {
    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(length = 500)
    private String summary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "publish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PostStatus status;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;
}
