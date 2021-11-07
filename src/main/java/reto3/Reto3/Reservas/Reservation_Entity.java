
package reto3.Reto3.Reservas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import reto3.Reto3.Client.Client_Entity;
import reto3.Reto3.Ortesis.Ortesis_Entity;

@Entity
@Table (name="reservation")
public class Reservation_Entity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
    private String score;
    
    @ManyToOne
    @JoinColumn(name= "id")
    @JsonIgnoreProperties("reservations")
    private Ortesis_Entity ortopedic;
    
    @ManyToOne
    @JoinColumn(name= "idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client_Entity client;
    

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Ortesis_Entity getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortesis_Entity ortopedic) {
        this.ortopedic = ortopedic;
    }

    public Client_Entity getClient() {
        return client;
    }

    public void setClient(Client_Entity client) {
        this.client = client;
    }   
}
