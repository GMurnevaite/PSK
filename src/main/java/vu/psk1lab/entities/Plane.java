package vu.psk1lab.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Plane.findAll", query = "select p from Plane as p ")
})
@Table(name = "PLANE")
@Getter
@Setter

public class Plane implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer plane_id;

    //@Size(max = 50)
    @Column(name = "PLANE_NO", nullable = false, unique = true)
    private String plane_no;

    @Column(name = "PILOT")
    private Integer pilot;

    @ManyToMany
    @JoinTable(name = "PLANES_OF_PILOT")
    @JoinColumn(name = "PILOT_ID")
    private List<Pilot> pilotList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "AIRLINE_ID")
    private Airline airline;

    public Plane(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane song = (Plane) o;
        return Objects.equals(plane_id, song.plane_id) && Objects.equals(plane_no, song.plane_no) && Objects.equals(pilot, song.pilot) && airline.equals(song.airline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plane_id, plane_no, pilot, airline);
    }


}
