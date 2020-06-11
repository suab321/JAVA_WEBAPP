package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.util.MyUserDetail;

@Service
public class myUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UserEntity> ue = userRepo.findByUserName(userName);
		ue.orElseThrow(()->new UsernameNotFoundException("userName"));
		return ue.map(MyUserDetail::new).get();
	}
	
}
