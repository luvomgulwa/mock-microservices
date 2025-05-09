package org.luvom.mockmicroservices.repository;

import org.luvom.mockmicroservices.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

    Optional<UserProfile> findByEmail(String email);

    List<UserProfile> findByActiveTrue();

    @Query("SELECT u FROM UserProfile u WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<UserProfile> searchByName(@Param("name") String name);

    @Query("SELECT u FROM UserProfile u WHERE u.address IS NOT NULL")
    List<UserProfile> findUsersWithAddress();

//    @Query("SELECT u FROM UserProfile u WHERE u.lastLogin < :cutoffDate")
//    List<UserProfile> findInactiveUsers(@Param("cutoffDate") LocalDateTime cutoffDate);
}
