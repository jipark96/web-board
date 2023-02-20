package study.webboard.board.entity;

import lombok.*;
import study.webboard.board.Dto.CompanyDetailDto;
import study.webboard.board.Dto.CompanyEditDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Data
@RequiredArgsConstructor
@Table(name = "company")
public class Company {

    @Id @GeneratedValue
    @Column(name = "com_id")
    private Long id;
    @Column(name = "com_name")
    private String name;
    @Column(name = "com_country")
    private String country;
    @Column(name = "com_area")
    private String area;

    @Column(name = "com_position")
    private String position;

    @Column(name = "com_compensation")
    public Long compensation;

    @Column(name = "com_content")
    public String content;

    @Column(name = "com_stack")
    public String stack;


    @Builder
    public Company(Long id, String name, String country, String area, String position, Long compensation, String content, String stack) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.area = area;
        this.position = position;
        this.compensation = compensation;
        this.content = content;
        this.stack = stack;
    }

    public void update(String position, Long compensation, String content, String stack) {
        this.position=position;
        this.compensation = compensation;
        this.content = content;
        this.stack = stack;
    }

    public Company(CompanyEditDto companyEditDto) {
        id = companyEditDto.getComId();
        position = companyEditDto.getComPosition();
        compensation = companyEditDto.getComCompensation();
        content = companyEditDto.getComContent();
        stack = companyEditDto.getComStack();
    }

    public Company(CompanyDetailDto companyDetailDto) {
        id = companyDetailDto.getComId();
        name = companyDetailDto.getComName();
        country = companyDetailDto.getComCountry();
        area = companyDetailDto.getComArea();
        position = companyDetailDto.getComPosition();
        compensation = companyDetailDto.getComCompensation();
        stack = companyDetailDto.getComStack();
        content = companyDetailDto.getComContent();
    }
}
