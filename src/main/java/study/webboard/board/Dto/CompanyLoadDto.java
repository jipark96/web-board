package study.webboard.board.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.webboard.board.entity.Company;

@Getter
@NoArgsConstructor
@Data
public class CompanyLoadDto {

    private Long comId;
    private String comName;
    private String comCountry;
    private String comArea;
    private String comPosition;
    private Long comCompensation;
    private String comStack;

    @Builder
    public CompanyLoadDto(Long comId, String comName, String comCountry, String comArea, String comPosition, Long comCompensation, String comStack) {
        this.comId = comId;
        this.comName = comName;
        this.comCountry = comCountry;
        this.comArea = comArea;
        this.comPosition = comPosition;
        this.comCompensation = comCompensation;
        this.comStack = comStack;
    }

    public CompanyLoadDto(Company company){

        comId=company.getId();
        comName=company.getName();
        comCountry=company.getCountry();
        comArea=company.getArea();
        comPosition=company.getPosition();
        comCompensation = company.getCompensation();
        comStack = company.getStack();
    }
}
