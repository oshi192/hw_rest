package com.yurii.hw_rest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode
@Table(name = "asterism")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Asterism {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private float area;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "asterism", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Star> stars = new ArrayList<>();

    public Asterism(String name, float area) {
        this.name = name;
        this.area = area;
    }
}
