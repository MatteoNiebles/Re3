package reto3.Reto3.Message;

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
import javax.persistence.Table;
import reto3.Reto3.Client.Client_Entity;
import reto3.Reto3.Ortesis.Ortesis_Entity;

@Entity
@Table (name="Message")
public class Message_Entity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private Ortesis_Entity ortopedic;
    
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private Client_Entity client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
