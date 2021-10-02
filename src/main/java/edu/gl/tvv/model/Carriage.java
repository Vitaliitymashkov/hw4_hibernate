package edu.gl.tvv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Carriage")
public class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "carriages")
    private Long serialNumber; //UUID

    @Column(name = "releaseYear")
    private Integer releaseYear;

    @Column(name = "paxCapacity")
    private Integer paxCapacity;

    public Carriage(Integer releaseYear, Integer paxCapacity) {
//        this.serialNumber = serialNumber;
        this.releaseYear = releaseYear;
        this.paxCapacity = paxCapacity;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getPaxCapacity() {
        return paxCapacity;
    }

    public void setPaxCapacity(Integer paxCapacity) {
        this.paxCapacity = paxCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carriage carriage = (Carriage) o;

        if (serialNumber != null ? !serialNumber.equals(carriage.serialNumber) : carriage.serialNumber != null)
            return false;
        if (releaseYear != null ? !releaseYear.equals(carriage.releaseYear) : carriage.releaseYear != null)
            return false;
        return paxCapacity != null ? paxCapacity.equals(carriage.paxCapacity) : carriage.paxCapacity == null;
    }

    @Override
    public int hashCode() {
        int result = serialNumber != null ? serialNumber.hashCode() : 0;
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (paxCapacity != null ? paxCapacity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "serialNumber=" + serialNumber +
                ", releaseYear=" + releaseYear +
                ", paxCapacity=" + paxCapacity +
                '}';
    }
}
