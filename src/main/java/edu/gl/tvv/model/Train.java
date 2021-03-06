package edu.gl.tvv.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "maxSpeed")
    private Integer maxSpeed;

    @Column(name = "routeNumber")
    private Integer routeNumber;

    @ManyToOne
    @JoinColumn(name = "depot_id")
    private Depot depotAddress;

    @Enumerated(EnumType.STRING)
    private TrainClass trainClass;

    @OneToMany(mappedBy = "train", cascade = CascadeType.PERSIST)
    List<Carriage> carriages = new ArrayList<>();
    ;

    public Train() {
    }

    public Train(Integer maxSpeed, Integer routeNumber, Depot depotAddress, TrainClass trainClass, List<Carriage> carriages) {
        this.maxSpeed = maxSpeed;
        this.routeNumber = routeNumber;
        this.depotAddress = depotAddress;
        this.trainClass = trainClass;
        this.carriages = carriages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(Integer routeNumber) {
        this.routeNumber = routeNumber;
    }

    public Depot getDepotAddress() {
        return depotAddress;
    }

    public void setDepotAddress(Depot depotAddress) {
        this.depotAddress = depotAddress;
    }

    public Enum<TrainClass> getTrainClass() {
        return trainClass;
    }

    public void setTrainClass(TrainClass trainClass) {
        this.trainClass = trainClass;
    }

    public List<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (maxSpeed != null ? !maxSpeed.equals(train.maxSpeed) : train.maxSpeed != null) return false;
        if (routeNumber != null ? !routeNumber.equals(train.routeNumber) : train.routeNumber != null) return false;
        if (depotAddress != null ? !depotAddress.equals(train.depotAddress) : train.depotAddress != null) return false;
        if (trainClass != null ? !trainClass.equals(train.trainClass) : train.trainClass != null) return false;
        return carriages != null ? carriages.equals(train.carriages) : train.carriages == null;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", maxSpeed=" + maxSpeed +
                ", routeNumber=" + routeNumber +
                ", depotAddress=" + depotAddress +
                ", trainClass=" + trainClass +
                ", carriages=" + carriages +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (maxSpeed != null ? maxSpeed.hashCode() : 0);
        result = 31 * result + (routeNumber != null ? routeNumber.hashCode() : 0);
        result = 31 * result + (depotAddress != null ? depotAddress.hashCode() : 0);
        result = 31 * result + (trainClass != null ? trainClass.hashCode() : 0);
        result = 31 * result + (carriages != null ? carriages.hashCode() : 0);
        return result;
    }
}
