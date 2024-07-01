package com.example.currencyrate.entity.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "RATE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rate {

    @Id
    private Long id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "ABBREVIATION")
    private String abbreviation;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SCALE")
    private Long scale;

    @Column(name = "OFFICIALRATE")
    private String officialRate;
}
