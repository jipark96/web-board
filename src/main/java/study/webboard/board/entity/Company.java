package study.webboard.board.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Table(name="company")
@RequiredArgsConstructor
public class Company {

    @Id
    @Column(name = "com_id")
    private Long id;
    @Column(name = "com_name")
    private String name;

    @Column(name = "com_country")
    private String country;

    @Column(name = "com_area")
    private String area;



}
