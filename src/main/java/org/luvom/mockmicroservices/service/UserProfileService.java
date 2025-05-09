package org.luvom.mockmicroservices.service;

import org.luvom.mockmicroservices.exception.ResourceNotFoundException;
import org.luvom.mockmicroservices.model.UserProfile;
import org.luvom.mockmicroservices.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    public UserProfile findById(String id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User profile not found with id: " + id));
    }

    public UserProfile save(UserProfile userProfile) {
        if(userProfile.getUserId() == null) {
            userProfile.setUserId(UUID.randomUUID().toString());
        }
        return userProfileRepository.save(userProfile);
    }

    public UserProfile update(String id, UserProfile userProfile) {
        UserProfile existingProfile = findById(id);
        existingProfile.setFirstName(userProfile.getFirstName());
        existingProfile.setLastName(userProfile.getLastName());
        existingProfile.setEmail(userProfile.getEmail());
        existingProfile.setPhone(userProfile.getPhone());
        existingProfile.setAddress(userProfile.getAddress());
//        existingProfile.setActive(userProfile.getActive());
        return userProfileRepository.save(existingProfile);
    }

    public void delete(String id) {
        UserProfile userProfile = findById(id);
        userProfileRepository.delete(userProfile);
    }

    public UserProfile findByEmail(String email) {
        return userProfileRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User profile not found with email: " + email));
    }

    public UserProfile deactivateUser(String id) {
        UserProfile userProfile = findById(id);
        userProfile.setActive(false);
        return userProfileRepository.save(userProfile);
    }
}
