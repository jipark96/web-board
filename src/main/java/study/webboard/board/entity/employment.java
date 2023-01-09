package study.webboard.board.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "employment")
public class employment {

    @Id
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_position")
    private String position;

    @Column(name = "emp_compenstion")
    private Long compenstion;

    @Column(name = "emp_stack")
    private String stack;

    @Column(name = "emp_content")
    private String content;
}
