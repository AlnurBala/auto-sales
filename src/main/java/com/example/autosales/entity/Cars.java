package com.example.autosales.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cars", schema = "public")
public class Cars {
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "car")
    List<Features> features;
    @Id
    @Column(name = "id", nullable = false)
    private Integer carId;
    @Column(name = "city")
    private String city;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "year_made")
    private Integer year;
    @Column(name = "ban_type")
    private String ban;
    @Column(name = "mileage")
    private String mileage;
    @Column(name = "color")
    private String color;
    @Column(name = "engine")
    private String engine;
    @Column(name = "gear_box")
    private String gearBox;
    @Column(name = "gear")
    private String gear;
    @Column(name = "car_is_new")
    private String carIsNew;
    @Column(name = "seats")
    private Integer seats;
    @Column(name = "owners")
    private Integer owners;
    @Column(name = "condition_of_car")
    private String condition;
    @Column(name = "market")
    private String market;
    @Column(name = "price")
    private Integer price;
    @Column(name = "upload_date")
    private Date uploadDate;
    @Column(name = "view_count")
    private Integer viewCount;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Sellers seller;


}
