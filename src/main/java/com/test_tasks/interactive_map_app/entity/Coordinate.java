package com.test_tasks.interactive_map_app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "coordinate")
public class Coordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @NonNull
    @Column(name = "longitude", nullable = false)
    private Double longitude;
}
