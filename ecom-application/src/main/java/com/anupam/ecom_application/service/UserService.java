package com.anupam.ecom_application.service;

import com.anupam.ecom_application.dto.AddressDTO;
import com.anupam.ecom_application.dto.UserRequestDTO;
import com.anupam.ecom_application.dto.UserResponseDTO;
import com.anupam.ecom_application.model.Address;
import com.anupam.ecom_application.model.User;
import com.anupam.ecom_application.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//    private List<User> userList = new ArrayList<>();
//    private Long id = 1l;

    public List<UserResponseDTO> fetchUsers() {
        List<User> userList = userRepository.findAll();
        return userRepository.findAll().stream()
                .map(u -> mapToUserResponse(u))
                .collect(Collectors.toList());
    }

    public void addUser(UserRequestDTO user) {
        User user1 = new User();
        updateUserFromRequest(user, user1);
        userRepository.save(user1);
    }

    public Optional<UserResponseDTO> fetchUserById(Long id) {
//        return userList.stream().filter(val -> val.getId().equals(id)).findFirst();
        return userRepository.findById(id).map(u -> mapToUserResponse(u));
    }

    public boolean updateUser(UserRequestDTO updatedUser, Long id) {
//        return userList.stream().filter(user -> user.getId().equals(id)).findFirst().map(existingUser -> {
//            existingUser.setFirstName(updatedUser.getFirstName());
//            existingUser.setLastName(updatedUser.getLastName());
//            return true;
//        }).orElse(false);

        return userRepository.findById(id).map(existingUser -> {
            updateUserFromRequest(updatedUser, existingUser);
            userRepository.save(existingUser);
            return true;
        }).orElse(false);
    }

    private void updateUserFromRequest(UserRequestDTO user1, User user) {
        user.setFirstName(user1.getFirstName());
        user.setLastName(user1.getLastName());
        user.setEmail(user1.getEmail());
        user.setPhone(user1.getPhone());

        if(user1.getAddress() != null) {
            Address address = new Address();
            address.setStreet(user1.getAddress().getStreet());
            address.setCity(user1.getAddress().getCity());
            address.setState(user1.getAddress().getState());
            address.setCountry(user1.getAddress().getCountry());
            address.setZipCode(user1.getAddress().getZipCode());
            user.setAddress(address);
        }
    }

    private UserResponseDTO mapToUserResponse(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(String.valueOf(user.getId()));
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole());

        if(user.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setState(user.getAddress().getState());
            addressDTO.setCountry(user.getAddress().getCountry());
            addressDTO.setZipCode(user.getAddress().getZipCode());
            response.setAddress(addressDTO);
        }

        return response;
    }
}
