package com.hooks.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record UserDto(
        Long userId,
        String username,
        LocalDate dob,
        String country,
        List<String> favouriteCategories
) {}
