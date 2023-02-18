package study.webboard.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.webboard.board.Dto.CompanyDetailDto;
import study.webboard.board.Dto.CompanyDto;
import study.webboard.board.Dto.CompanyLoadDto;
import study.webboard.board.service.CompanyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    //[채용공고 등록]
    @PostMapping("/company/add")
    public void addCompany(@RequestBody CompanyDto companyDto) {
        companyService.saveCompany(companyDto);
    }

   //[채용공고 수정]
    @PutMapping("/company/update")
    public CompanyDto updateCompany(@RequestBody CompanyDto companyDto) {
        companyService.updateCompany(companyDto);
        return companyDto;
    }

    //[채용공고 삭제]
    @DeleteMapping("/company/delete/{id}")
    public Long deleteCompany(@PathVariable Long id) {
        return companyService.deleteCompany(id);
    }

    //[채용공고 목록]
    @GetMapping("/company/list")
    public List<CompanyLoadDto> companyList() {
        return companyService.companyList();
    }

    //[채용공고 상세보기]
    @GetMapping("/company/detail/{id}")
    public CompanyDetailDto companyDetail(@PathVariable Long id) {
        return companyService.companyDetail(id);
    }

}
