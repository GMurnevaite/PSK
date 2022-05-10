package vu.psk1lab.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
        @NamedQuery(name = "Airline.findAll", query = "select a from Airline as a ")
})
@Table(name = "AIRLINE")

@Getter
@Setter

public class Airline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airline_id;

    @Size(max = 50)
    @Column(name = "AIRLINE_NAME", nullable = false, unique = true)
    private String airline_name;

    @OneToMany(mappedBy = "airline")
    private List<Plane> planeList = new ArrayList<>();

    @OneToMany(mappedBy = "airlinesId")
    private List<Pilot> pilotsList = new ArrayList<>();

    public Airline(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(airline_id, airline.airline_id) && Objects.equals(airline_name, airline.airline_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airline_id, airline_name);
    }

}
