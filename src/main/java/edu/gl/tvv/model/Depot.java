package edu.gl.tvv.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Depot")
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(mappedBy = "depotAddress", cascade = CascadeType.PERSIST)
    private Long id;

    @Column(name = "city")
    private String city;

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

        if (id != null ? !id.equals(depot.id) : depot.id != null) return false;
        return city != null ? city.equals(depot.city) : depot.city == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
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
