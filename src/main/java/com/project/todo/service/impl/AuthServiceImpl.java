package com.project.todo.service.impl;

import com.project.todo.dto.LoginDto;
import com.project.todo.dto.RegisterDto;
import com.project.todo.entity.Role;
import com.project.todo.entity.User;
import com.project.todo.exception.TodoAPIException;
import com.project.todo.repository.RoleRepo;
import com.project.todo.repository.UserRepo;
import com.project.todo.security.JWTTokenProvider;
import com.project.todo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
   private UserRepo userRepo;
   private RoleRepo roleRepo;
   private PasswordEncoder passwordEncoder;
   private AuthenticationManager authenticationManager;
   private JWTTokenProvider jwtTokenProvider;
    @Override
    public String register(RegisterDto registerDto) {
        //check username already exists in database
        if(userRepo.existsByUsername(registerDto.getUsername())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Username already exists");
        }
        if(userRepo.existsByEmail(registerDto.getEmail())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Email already exists");
        }
        User user=new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));


        Set<Role>  roles=new HashSet<>();
        Role userRole=roleRepo.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);
        userRepo.save(user);
        return "User registered successfully ";
    }

    @Override
    public String login(LoginDto loginDto) {
      Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
              loginDto.getUsernameOrEmail(),
              loginDto.getPassword()
      ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token= jwtTokenProvider.generateToken(authentication);
        //return "User logged in sucessfully";
        return token;
    }
}
