package study.webboard.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.webboard.board.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
