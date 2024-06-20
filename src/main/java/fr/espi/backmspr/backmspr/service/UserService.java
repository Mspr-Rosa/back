package fr.espi.backmspr.backmspr.service;

import fr.espi.backmspr.backmspr.entity.UserEntity;
import fr.espi.backmspr.backmspr.entity.dto.UserDTO;
import fr.espi.backmspr.backmspr.entity.dto.UserReponseDTO;
import fr.espi.backmspr.backmspr.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

import java.util.List;

@Component
public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<UserReponseDTO> findAll(){

        List<UserEntity> users = userRepository.findAll();

        List<UserReponseDTO> userReponses = new ArrayList<>();
        for(UserEntity user : users){
            UserReponseDTO userReponseDTO = new UserReponseDTO(user.getId(),user.getUsername());
            userReponses.add(userReponseDTO);
        }

        return userReponses;
    }

    private String hashPassword(String password) {
        // Utilisation de BCrypt pour hacher le mot de passe
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public UserEntity makeUser(UserDTO userDTO){

        UserEntity user = new UserEntity();
        user.setUser(userDTO.getUser());

        if (!isValidPassword(userDTO.getMdp())) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 12 caractères comprenant au moins une majuscule, des minuscules, un chiffre et un caractère spécial.");
        }
        else {
            String hashedMdp = hashPassword(userDTO.getMdp());
            user.setMdp(hashedMdp);
        }
        return userRepository.save(user);
    }

    private boolean isValidPassword(String password) {
        // Vérification de la longueur du mot de passe
        if (password.length() < 12) {
            return false;
        }

        // Vérification de la présence de majuscules, minuscules, chiffres et caractères spéciaux
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Pattern.matches("[^a-zA-Z0-9\\s]", Character.toString(c))) {
                hasSpecialChar = true;
            }
        }

        // Vérification de la présence de chaque type de caractère
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

}
