package com.dataservice;

import com.datamodel.ERole;
import com.datamodel.Role;
import com.datamodel.User;
import com.repository.IUserRepository;
import com.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User is not found in the database");
        }else {

        }
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority(role.getName().name()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
    }

    @Override
    public User SaveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return iUserRepository.save(user);
    }

    @Override
    public void AddRoleToUser(String username, ERole roles) {
        User user = iUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(roles);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return iUserRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return iUserRepository.findAll();
    }


}
