package com.ga.service;

import com.ga.entity.Song;
import com.ga.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public User signup(User user);

    public User singIn(User user);

    public Long deleteUser(Long userId);

    public User updateUser(User user, Long userId);

    public User getUserByUserName(String username);

    public List<Song> getSongs(String username);

    public List<Song> addSong(String username, Long songId);

}
