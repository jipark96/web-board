package study.webboard.board.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.webboard.board.entity.Company;

@Getter
@NoArgsConstructor
@Data
public class CompanyDto {

    private Long id;
    private String position;
    public Long compensation;
    public String content;
    public String stack;

    public CompanyDto(Company company) {
        id=company.getId();
        position = company.getPosition();
        compensation = company.getCompensation();
        content = company.getContent();
        stack = company.getStack();
    }

    public CompanyDto(Long id, String position, Long compensation, String content, String stack) {
        this.id = id;
        this.position = position;
        this.compensation = compensation;
        this.content = content;
        this.stack = stack;
    }
}
