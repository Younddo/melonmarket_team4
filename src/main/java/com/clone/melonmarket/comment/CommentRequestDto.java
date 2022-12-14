package com.clone.melonmarket.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

//    private Long commentId;

    @NotBlank(message = "댓글을 작성해주세요!")
    private String comment;

//    private Long step;

}
