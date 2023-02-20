package study.webboard.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.webboard.board.Dto.CompanyDetailDto;
import study.webboard.board.Dto.CompanyEditDto;
import study.webboard.board.Dto.CompanyLoadDto;
import study.webboard.board.entity.Company;
import study.webboard.board.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    //[채용공고 등록]
    @Transactional
    public void saveCompany(CompanyDetailDto companyDetailDto) {
        Company company = new Company(companyDetailDto);
        companyRepository.save(company);
    }

    //[채용공고 수정]
    @Transactional
    public Long updateCompany(CompanyEditDto companyEditDto) {
        Company company = companyRepository.findById(companyEditDto.getComId())
                .orElseThrow(() -> new IllegalArgumentException("id가 존재하지 않습니다."));

        company.update(companyEditDto.getComPosition(), companyEditDto.getComCompensation(), companyEditDto.getComContent(), companyEditDto.getComStack());
        companyRepository.save(company);
        return 1L;
    }

    //[채용공고 삭제]
    @Transactional
    public Long deleteCompany(Long id) {
        companyRepository.deleteById(id);
        return 1L;
    }

    //[채용공고 목록]
    @Transactional
    public List<CompanyLoadDto> companyList() {
        List<Company> CompanyList = companyRepository.findAll();
        List<CompanyLoadDto> CompanyLoadDtoList = new ArrayList<>();

        for (Company company : CompanyList) {
            CompanyLoadDto companyLoadDto = CompanyLoadDto.builder()
                    .comId(company.getId())
                    .comName(company.getName())
                    .comCountry(company.getCountry())
                    .comArea(company.getArea())
                    .comPosition(company.getPosition())
                    .comCompensation(company.getCompensation())
                    .comStack(company.getStack())
                    .build();
            CompanyLoadDtoList.add(companyLoadDto);
        }
        return CompanyLoadDtoList;
    }

    //[채용공고 상세 정보]
    @Transactional
    public CompanyDetailDto companyDetail(Long id) {
        Company company = companyRepository.findById(id).get();
        CompanyDetailDto companyDetailDto = CompanyDetailDto.builder()
                .comId(company.getId())
                .comName(company.getName())
                .comCountry(company.getCountry())
                .comArea(company.getArea())
                .comPosition(company.getPosition())
                .comCompensation(company.getCompensation())
                .comStack(company.getStack())
                .comContent(company.getContent())
                .build();
        return companyDetailDto;
    }

    @Transactional
    public List<CompanyLoadDto> companySearch(String keyword) {
        return companyRepository.findAllSearch(keyword).stream()
                .map(company -> new CompanyLoadDto(company))
                .collect(Collectors.toList());
    }
}