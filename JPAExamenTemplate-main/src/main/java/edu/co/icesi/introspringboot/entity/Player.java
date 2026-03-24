package edu.co.icesi.introspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String position;

    @Column(name = "fifa_score")
    private Integer fifaScore;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "player")
    private List<PlayerClub> playerClubs;

    public Player() {
    }

    public Player(String name, LocalDate birthDate, String position, Integer fifaScore, Country country) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.fifaScore = fifaScore;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getFifaScore() {
        return fifaScore;
    }

    public void setFifaScore(Integer fifaScore) {
        this.fifaScore = fifaScore;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<PlayerClub> getPlayerClubs() {
        return playerClubs;
    }

    public void setPlayerClubs(List<PlayerClub> playerClubs) {
        this.playerClubs = playerClubs;
    }
}
