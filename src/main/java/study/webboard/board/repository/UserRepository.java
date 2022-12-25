package study.webboard.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.webboard.board.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
