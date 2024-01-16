package hiber.model;

import javax.persistence.*;

@Entity
public class Car {

    @Column
    private String model;

    @Column
    private int series;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "car")
    User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }
    @Override
    public String toString() {
        return model + " " + series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}