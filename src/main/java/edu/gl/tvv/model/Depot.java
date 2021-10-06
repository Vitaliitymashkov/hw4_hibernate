package edu.gl.tvv.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
//@Table(name = "Depot")
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    @OneToMany(mappedBy = "depotAddress", cascade = CascadeType.PERSIST)
    private List<Train> trains;

    public void addTrain(Train train) {
        this.trains.add(train);
        train.setDepotAddress(this);
    }


    public Depot() {
    }

    @Override
    public String toString() {
        return "Depot{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Depot depot = (Depot) o;

        return city != null ? city.equals(depot.city) : depot.city == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Depot(String city) {
        this.city = city;
    }
}
