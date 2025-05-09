package org.luvom.mockmicroservices.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.luvom.mockmicroservices.model.UserProfile;
import org.luvom.mockmicroservices.service.UserProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-profiles")
@Tag(name = "User Profile Controller", description = "Operations related to user profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    @Operation(summary = "Get all user profiles")
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        return ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user profile by ID")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable String id) {
        return ResponseEntity.ok(userProfileService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new user profile")
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userProfileService.save(userProfile));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user profile")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable String id, @RequestBody UserProfile userProfile) {
        return ResponseEntity.ok(userProfileService.update(id, userProfile));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user profile")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable String id) {
        userProfileService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get user profile by email")
    public ResponseEntity<UserProfile> getUserProfileByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userProfileService.findByEmail(email));
    }
}
