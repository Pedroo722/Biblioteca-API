package br.edu.ifpb.biblioteca.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifpb.biblioteca.dto.RegisterUserRequestDTO;
import br.edu.ifpb.biblioteca.dto.UserRequestDTO;
import br.edu.ifpb.biblioteca.dto.UserResponseDTO;
import br.edu.ifpb.biblioteca.exceptions.UnauthorizedAccessException;
import br.edu.ifpb.biblioteca.exceptions.UserNotFoundException;
import br.edu.ifpb.biblioteca.model.Role;
import br.edu.ifpb.biblioteca.model.User;
import br.edu.ifpb.biblioteca.repository.UserRepository;
import br.edu.ifpb.biblioteca.util.UserValidations;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserResponseDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .filter(user -> user.getRole() != Role.ADMIN)
                .map(user ->
                    new UserResponseDTO(user.getName(), user.getEmail(),
                                        user.getPhone(), user.getAddress()))
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserByEmail(String email) {
        User userFound = findUserByEmail(email);
        return new UserResponseDTO(userFound.getName(), userFound.getEmail(), userFound.getPhone(), userFound.getAddress());
    }

    public User saveUser(RegisterUserRequestDTO user) {
        UserValidations.validateEmail(user.email());

        User newUser = new User();
        newUser.setName(user.name());
        newUser.setEmail(user.email());
        newUser.setPassword(passwordEncoder.encode(user.password()));
        newUser.setPhone(user.phone());
        newUser.setAddress(user.address());
        newUser.setRole(Role.USER);

        return userRepository.save(newUser);
    }

    public UserResponseDTO updateUser(String email, UserRequestDTO user) {
        User userToEdit = findUserByEmail(email);

        User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userEmail = loggedUser.getEmail();

        if(!userToEdit.getEmail().equals(userEmail) && loggedUser.getRole() != Role.ADMIN) {
            throw new UnauthorizedAccessException();
        }

        userToEdit.setName(user.name());
        userToEdit.setPassword(passwordEncoder.encode(user.password()));
        userToEdit.setPhone(user.phone());
        userToEdit.setAddress(user.address());
        userRepository.save(userToEdit);

        return new UserResponseDTO(userToEdit.getName(), userToEdit.getEmail(), userToEdit.getPhone(), userToEdit.getAddress());
    }

    public void deleteUser(String email) {
        User userToDelete = findUserByEmail(email);

        User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userEmail = loggedUser.getEmail();

        if(!userToDelete.getEmail().equals(userEmail) && loggedUser.getRole() != Role.ADMIN) {
            throw new UnauthorizedAccessException();
        }

        userRepository.deleteById(userToDelete.getId());
    }

    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        return user.get();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Usuário com email " + email + " não encontrado.");
        }

        return user.get();
    }

    public void upgradeRole(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        user.get().setRole(Role.ADMIN);
        userRepository.save(user.get());
    }

    public void downgradeRole(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        user.get().setRole(Role.USER);
        userRepository.save(user.get());
    }
}