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
        @NamedQuery(name = "Pilot.findAll", query = "select pil from Pilot as pil ")
})
@Table(name = "PILOT")
@Getter
@Setter
public class Pilot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer pilot_id;

    //@Size(max = 50)
    @Column(name = "PILOT_NAME")
    private String pilot_name;

    @Column(name = "AIRLINE")
    private String airline_name;

//    @Column(name = "Plane_ID")
//    private String plane_id;

    @ManyToMany(mappedBy = "pilotList")
    private List<Plane> planeList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "AIRLINES_ID")
    private Airline airlinesId;


    public Pilot(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot album = (Pilot) o;
        return pilot_id.equals(album.pilot_id) && pilot_name.equals(album.pilot_name) && airline_name.equals(album.airline_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pilot_id, pilot_name, airline_name);
    }

}
