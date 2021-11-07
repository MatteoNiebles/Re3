package reto3.Reto3.Ortesis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import reto3.Reto3.Category.Category_Entity;
import reto3.Reto3.Message.Message_Entity;
import reto3.Reto3.Reservas.Reservation_Entity;

@Entity
@Table(name="Ortopedic")
public class Ortesis_Entity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer name;
    private String brand;
    private Integer year;
    private String description;
    
     @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("ortopedics")
    private Category_Entity category;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="ortopedic")
    @JsonIgnoreProperties({"ortopedic","client"})
    private List<Message_Entity> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="ortopedic")
    @JsonIgnoreProperties({"ortopedic","client"})
    private List<Reservation_Entity> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category_Entity getCategory() {
        return category;
    }

    public void setCategory(Category_Entity category) {
        this.category = category;
    }

    public List<Message_Entity> getMessages() {
        return messages;
    }

    public void setMessages(List<Message_Entity> messages) {
        this.messages = messages;
    }

    public List<Reservation_Entity> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation_Entity> reservations) {
        this.reservations = reservations;
    }
    
   
    
}
