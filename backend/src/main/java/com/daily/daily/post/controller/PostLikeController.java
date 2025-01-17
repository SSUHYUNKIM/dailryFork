package com.daily.daily.post.controller;

import com.daily.daily.common.dto.SuccessResponseDTO;
import com.daily.daily.post.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts/{postId}/likes")
public class PostLikeController {

    private final PostLikeService postLikeService;

    @PostMapping
    public SuccessResponseDTO increaseLikeCount(@AuthenticationPrincipal Long memberId, @PathVariable Long postId) {
        postLikeService.increaseLikeCount(memberId, postId);
        return new SuccessResponseDTO();
    }

    @DeleteMapping
    public SuccessResponseDTO decreaseLikeCount(@AuthenticationPrincipal Long memberId, @PathVariable Long postId) {
        postLikeService.decreaseLikeCount(memberId, postId);
        return new SuccessResponseDTO();
    }
}
