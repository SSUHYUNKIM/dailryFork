package com.daily.daily.dailrypage.repository;

import com.daily.daily.dailrypage.dto.DailryPageThumbnailDTO;

import java.util.List;

public interface DailryPageQuerydsl {
    List<DailryPageThumbnailDTO> findThumbnails(Long dailryId);

}
