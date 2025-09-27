package com.hooks.service;

import com.hooks.dto.UserDto;
import com.hooks.model.User;
import com.hooks.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public List<User> getAll() {
        return repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public User create(UserDto dto) {
        User user = User.builder()
                .username(dto.username())
                .dob(dto.dob())
                .country(dto.country())
                .favouriteCategories(dto.favouriteCategories())
                .build();
        return repo.save(user);
    }

    public User update(Long id, UserDto dto) {
        User user = repo.findById(id).orElseThrow();
        user.setUsername(dto.username());
        user.setDob(dto.dob());
        user.setCountry(dto.country());
        user.setFavouriteCategories(dto.favouriteCategories());
        return repo.save(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
