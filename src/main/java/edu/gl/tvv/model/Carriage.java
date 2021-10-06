package edu.gl.tvv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Carriage {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private UUID serialNumber;

    private Integer releaseYear;

    private Integer paxCapacity;

    @ManyToOne
    @JoinColumn(name = "train_id")
    Train train;

    public Carriage() {
    }

    public Carriage(Integer releaseYear, Integer paxCapacity) {
        this.releaseYear = releaseYear;
        this.paxCapacity = paxCapacity;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(UUID serialNumber) {
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

        if (releaseYear != null ? !releaseYear.equals(carriage.releaseYear) : carriage.releaseYear != null)
            return false;
        return paxCapacity != null ? paxCapacity.equals(carriage.paxCapacity) : carriage.paxCapacity == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
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
