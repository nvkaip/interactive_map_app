package com.test_tasks.interactive_map_app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "numberOfRooms")
    private Integer numberOfRooms;

    @NonNull
    @Column(name = "area")
    private Double area;

    @NonNull
    @Column(name = "description")
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images;

    @NonNull
    @Column(name = "address")
    private String address;

    @NonNull
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "coordinate_id")
    private Coordinate coordinate;
}
