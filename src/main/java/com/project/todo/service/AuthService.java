package com.project.todo.service;

import com.project.todo.dto.LoginDto;
import com.project.todo.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
