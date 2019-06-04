package com.yurii.hw_rest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
@Table(name = "star")
@NoArgsConstructor
public class Star {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private float magnitude;
    private String starClass;
    private String  cao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "asterism_id")
    @JsonBackReference
    private Asterism asterism;

    public Star(String name, float magnitude, String starClass, String cao,Asterism asterism) {
        this.name = name;
        this.magnitude = magnitude;
        this.starClass = starClass;
        this.cao = cao;
        this.asterism=asterism;
    }
}
