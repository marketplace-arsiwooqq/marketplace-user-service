package com.arsiwooqq.userservice.service;

import com.arsiwooqq.userservice.dto.UserCreateRequest;
import com.arsiwooqq.userservice.dto.UserResponse;
import com.arsiwooqq.userservice.dto.UserUpdateRequest;
import com.arsiwooqq.userservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    UserResponse create(UserCreateRequest request);

    User getEntityByUserId(String userId);

    @Transactional(readOnly = true)
    UserResponse getByUserId(String userId);

    UserResponse getByEmail(String email);

    Page<UserResponse> getAllPaged(Pageable pageable);

    @Transactional
    void update(String userId, UserUpdateRequest request);

    @Transactional
    void delete(String userId);

    void evictUserCache(User user);
}
