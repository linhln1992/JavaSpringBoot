package com.example.users.controller;

import com.example.users.config.JwtTokenUtil;
import com.example.users.dto.JwtRequest;
import com.example.users.dto.JwtResponse;
import com.example.users.service.JwtUserDetailsService;
import com.example.users.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

	private final UserSession userSession;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService jwtInMemoryUserDetailsService;

	public JwtAuthenticationController(UserSession userSession) {
		this.userSession = userSession;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		userSession.setUserId(1L);
		userSession.setRoleId(authenticationRequest.getRoleId());
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PutMapping("/logout")
	public boolean logout(){
		userSession.setUserId(null);
		userSession.setRoleId(null);
		return true;
	}

}
