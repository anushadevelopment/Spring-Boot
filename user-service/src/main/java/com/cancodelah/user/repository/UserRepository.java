package com.cancodelah.user.repository;
import com.cancodelah.user.entity.User;
import com.cancodelah.user.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByuserId(Long userId);
}
