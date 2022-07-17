package com.project.DeliveryAgentFrontend.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.DeliveryAgentFrontend.dao.AppDao;
import com.project.DeliveryAgentFrontend.entity.User;
import com.project.DeliveryAgentFrontend.entity.UserInfo;

//import com.project.BuyerFrontend.dao.UserDAO;

@Service
public class UserService implements UserDetailsService {
//	@Autowired
//	private UserDAO dao;
	
	@Autowired
	private AppDao appDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Integer id;
		try {
			id = Integer.parseInt(username);
		} catch (NumberFormatException e) {
			throw new UsernameNotFoundException("This user does not exist");
		}
//		Optional<User> user=dao.findById(id);
//		
//		System.out.println("User in Service Layer :"+user);
//		if(!user.isPresent()) {
//			throw new UsernameNotFoundException("This user does not exist");
//		}
//		UserInfo info=new UserInfo();
//		info.setPassword(user.get().getPassword());
//		info.setRole("USER");
//		info.setUid(user.get().getMobileNumber());
//		info.setUsername(username);
//		return info;
		
		User user=appDao.getUser(id);
		
		System.out.println("User in Service Layer :"+user);
		if(user==null) {
			throw new UsernameNotFoundException("This user does not exist");
		}
		UserInfo info=new UserInfo();
		info.setPassword(user.getPassword());
		info.setRole(user.getRole());
		info.setUid(user.getMobileNumber());
		info.setUsername(username);
		return info;
	}
	
}
