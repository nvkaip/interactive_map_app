package com.test_tasks.interactive_map_app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numberOfRooms")
    private Integer numberOfRooms;

    @Column(name = "area")
    private Double area;

    @Column(name = "description")
    private String description;

    @ElementCollection
    private List<String> images;//TODO figure this out

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "coordinate_id")
    private Coordinate coordinate;

    public Property() {
    }

    public Property(Integer numberOfRooms, Double area, String description, String address, Coordinate coordinate) {
        this.numberOfRooms = numberOfRooms;
        this.area = area;
        this.description = description;
        this.address = address;
        this.coordinate = coordinate;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getImages() {
        return images;
    }

    public void setImages(List images) {
        this.images = images;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(id, property.id) &&
                Objects.equals(numberOfRooms, property.numberOfRooms) &&
                Objects.equals(area, property.area) &&
                Objects.equals(description, property.description) &&
                Objects.equals(address, property.address) &&
                Objects.equals(coordinate, property.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfRooms, area, description, address, coordinate);
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", numberOfRooms=" + numberOfRooms +
                ", area=" + area +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", coordinate=" + coordinate +
                '}';
    }
}
