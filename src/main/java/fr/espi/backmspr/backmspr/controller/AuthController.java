package fr.espi.backmspr.backmspr.controller;

import fr.espi.backmspr.backmspr.entity.dto.AuthResponseDTO;
import fr.espi.backmspr.backmspr.entity.dto.LoginDTO;
import fr.espi.backmspr.backmspr.repository.RoleRepository;
import fr.espi.backmspr.backmspr.repository.UserRepository;
import fr.espi.backmspr.backmspr.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.espi.backmspr.backmspr.entity.dto.RegisterDTO;
import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.entity.Role;
import fr.espi.backmspr.backmspr.repository.RoleRepository;

import java.util.Collections;


@RequestMapping("auth")
@RestController
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){

        System.out.println(loginDTO.getUsername());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO RegisterDTO) {
        if (userRepository.existsByUsername(RegisterDTO.getUsername())) {
            return new ResponseEntity<>("Nom d'utilisateur déjà pris !", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setUser(RegisterDTO.getUsername());
        user.setMdp(passwordEncoder.encode((RegisterDTO.getPassword())));

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return new ResponseEntity<>("Utilisateur créé avec succés !", HttpStatus.OK);
    }
}
