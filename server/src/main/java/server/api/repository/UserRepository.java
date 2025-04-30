package server.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.api.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
