package com.example.computerpartsform.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "computer_forms")
@ToString
public class ComputerForm {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computer_form_seq")
    @SequenceGenerator(name = "computer_form_seq", sequenceName = "computer_form_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "part_id")
    @NotNull
    private ComputerPart part;

    @NotBlank
    @Column(nullable = false)
    private String justification;

    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeStamp;

    public ComputerForm(ComputerPart part, String justification, Date timeStamp) {
        this.part = part;
        this.justification = justification;
        this.timeStamp = timeStamp;
    }


    public ComputerForm(ComputerPart part, String justification) {
        this.part = part;
        this.justification = justification;
    }
}
