package com.clone.melonmarket.post;


import com.clone.melonmarket.account.Account;
import com.clone.melonmarket.comment.Comment;
import com.clone.melonmarket.global.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String content;
    private String price;
    private Long postLikeCount = 0L;
    private String place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private Account account;

    private Boolean status = false;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Image> image;

    public Post(PostRequestDto postRequestDto, Account account) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.price = postRequestDto.getPrice();
        this.place = postRequestDto.getPlace();
        this.account = account;
    }

    public void updatePost(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.price = postRequestDto.getPrice();
        this.place = postRequestDto.getPlace();
    }

    public void updatePostLikeCnt(Long postLikeCount) {
        this.postLikeCount = postLikeCount;
    }

    public void updatePostStatus(Boolean status){
        this.status = status;
    }

}
