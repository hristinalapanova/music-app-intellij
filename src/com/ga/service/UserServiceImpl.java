package com.ga.service;

import com.ga.dao.SongDao;
import com.ga.dao.UserDao;
import com.ga.entity.Song;
import com.ga.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUserName(username);

        if(user==null)
            throw new UsernameNotFoundException("Unkknown user: " +username);

        return new org.springframework.security.core.userdetails.User(user.getUserName(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        return authorities;
    }


    @Override
    public User signup(User user) {
        return null;
    }

    @Override
    public User singIn(User user) {
        return null;
    }

    @Override
    public Long deleteUser(Long userId) {
        return null;
    }

    @Override
    public User updateUser(User user, Long userId) {
        return null;
    }

    @Override
    public User getUserByUserName(String username) {
        return null;
    }

    @Override
    public List<Song> getSongs(String username) {
        return null;
    }

    @Override
    public List<Song> addSong(String username, Long songId) {
        return null;
    }
}
