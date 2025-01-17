package com.daily.daily.post.controller;

import com.daily.daily.common.dto.SuccessResponseDTO;
import com.daily.daily.post.dto.PostReadResponseDTO;
import com.daily.daily.post.dto.PostReadSliceResponseDTO;
import com.daily.daily.post.dto.PostWriteRequestDTO;
import com.daily.daily.post.dto.PostWriteResponseDTO;
import com.daily.daily.post.service.PostService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    @Secured(value = "ROLE_MEMBER")
    @ResponseStatus(HttpStatus.CREATED)
    public PostWriteResponseDTO createPost(
            @AuthenticationPrincipal Long id,
            @RequestPart @Valid PostWriteRequestDTO request,
            @RequestPart @NotNull MultipartFile pageImage
    ) {
        return postService.create(id, request, pageImage);
    }

    @PostMapping("/{postId}/edit")
    @Secured(value = "ROLE_MEMBER")
    public PostWriteResponseDTO updatePost(
            @AuthenticationPrincipal Long memberId,
            @PathVariable Long postId,
            @RequestPart @Valid PostWriteRequestDTO request,
            @RequestPart @Nullable MultipartFile pageImage
    ) {
        return postService.update(memberId, postId, request, pageImage);
    }

    @GetMapping("/{postId}")
    public PostReadResponseDTO readSinglePost(@PathVariable Long postId) {
        return postService.find(postId);
    }

    @GetMapping
    public PostReadSliceResponseDTO readSlicePost(Pageable pageable) {
        return postService.findSlice(pageable);
    }


    @DeleteMapping("/{postId}")
    @Secured(value = "ROLE_MEMBER")
    public SuccessResponseDTO deletePost(
            @AuthenticationPrincipal Long memberId,
            @PathVariable Long postId
    ) {
        postService.delete(memberId, postId);
        return new SuccessResponseDTO();
    }
}
