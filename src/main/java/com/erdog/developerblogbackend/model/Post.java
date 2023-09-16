package com.erdog.developerblogbackend.model;

import com.erdog.developerblogbackend.model.base.BaseModel;
import com.erdog.developerblogbackend.model.enums.PostStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @JoinColumn(name = "author_id")
    private User userId;

    @Column(name = "publish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PostStatus status;
}
