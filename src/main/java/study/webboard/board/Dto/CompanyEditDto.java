package study.webboard.board.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.webboard.board.entity.Company;

@Getter
@NoArgsConstructor
@Data
public class CompanyEditDto {

    private Long comId;
    private String comPosition;
    public Long comCompensation;
    public String comContent;
    public String comStack;

    public CompanyEditDto(Company company) {
        comId=company.getId();
        comPosition = company.getPosition();
        comCompensation = company.getCompensation();
        comContent = company.getContent();
        comStack = company.getStack();
    }

    public CompanyEditDto(Long comId, String comPosition, Long comCompensation, String comContent, String comStack) {
        this.comId = comId;
        this.comPosition = comPosition;
        this.comCompensation = comCompensation;
        this.comContent = comContent;
        this.comStack = comStack;
    }
}


