package study.webboard.board.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import study.webboard.board.entity.Company;
import study.webboard.board.service.CompanyService;

import java.util.List;

@Controller
public class CompanyController {
    private final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService=companyService;
    }
    //[글 작성 폼]
    @GetMapping("/company/write")
    public String companyWrite() {
        return "companywrite";
    }
    //[글 작성]
    @PostMapping("/company/writepro")
    public String companyWritePro(Company company) {
        companyService.write(company);
        return "redirect:/company/list";
    }
    //[목록]
    @GetMapping("/company/list")
    public String companyList(Model model, @PageableDefault Pageable pageable,
                              String searchKeyword) {

        Page<Company> list=null;
        if(searchKeyword == null) {
            list = companyService.companyList(pageable);
        } else {
            list = companyService.companySearchList(searchKeyword, pageable);
        }

        model.addAttribute("list",list);
        return "companylist";
    }
    //[상세 정보]
    @GetMapping("/company/view") //http://localhost:8080/company/view?id=1
    public String companyView(Model model,Integer id) {
        model.addAttribute("company",companyService.companyView(id));
        return "companyview";
    }
    //[삭제]
    @GetMapping("/company/delete") //http://localhost:8080/company/delete?id=3
    public String companyDelete(Integer id) {
        companyService.companyDelete(id);
        return "redirect:/company/list";
    }
    //[수정 폼]
    @GetMapping("/company/edit/{id}")
    public String companyEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("company",companyService.companyView(id));
        return "companyedit";
    }
    //[수정]
    @PostMapping("/company/update/{id}")
    public String companyUpdate(@PathVariable("id") Integer id, Company company) {

        Company findCompany = companyService.companyView(id); //기존 데이터

        findCompany.setId(company.getId());
        findCompany.setName(company.getName());
        findCompany.setPosition(company.getPosition());
        findCompany.setMoney(company.getMoney());
        findCompany.setContent(company.getContent());
        findCompany.setTech(company.getTech());

        companyService.write(findCompany);

        return "redirect:/company/list";
    }
}
