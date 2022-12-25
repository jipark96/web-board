package study.webboard.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import study.webboard.board.entity.Company;
import study.webboard.board.repository.CompanyRepository;



@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository=companyRepository;
    }
    //[채용공고 등록]
    public void write(Company company) {
        companyRepository.save(company);
    }
    //[채용공고 리스트 처리]
    public Page<Company> companyList(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    //[채용공고 상세 정보]
    public Company companyView(Integer id) {
        return companyRepository.findById(id).get();
    }
    //[채용공고 삭제]
    public void companyDelete(Integer id) {
        companyRepository.deleteById(id);
    }
    //[게시물 검색]
    public Page<Company> companySearchList(String searchKeyword, Pageable pageable) {
            return companyRepository.findByPositionContaining(searchKeyword, pageable);
    }


}
