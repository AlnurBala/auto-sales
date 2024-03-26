package com.example.autosales.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "features", schema = "public")
public class Features {
    @Id
    @Column(name = "id", nullable = false)
    private Integer featureId;
    @Column(name = "feature")
    private String feature;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Cars car;

}
