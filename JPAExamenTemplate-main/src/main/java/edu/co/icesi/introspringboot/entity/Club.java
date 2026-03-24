package edu.co.icesi.introspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String city;
    private LocalDate founded;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "club")
    private List<PlayerClub> playerClubs;

    public Club() {
    }

    public Club(String name, String city, LocalDate founded, Country country) {
        this.name = name;
        this.city = city;
        this.founded = founded;
        this.country = country;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public LocalDate getFounded() { return founded; }
    public void setFounded(LocalDate founded) { this.founded = founded; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    public List<PlayerClub> getPlayerClubs() { return playerClubs; }
    public void setPlayerClubs(List<PlayerClub> playerClubs) { this.playerClubs = playerClubs; }
}
