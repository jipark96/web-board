package study.webboard.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.webboard.board.entity.Company;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "select c from Company c where c.name like %:keyword% or c.stack like %:keyword%")
    List<Company> findAllSearch(String keyword);

}
