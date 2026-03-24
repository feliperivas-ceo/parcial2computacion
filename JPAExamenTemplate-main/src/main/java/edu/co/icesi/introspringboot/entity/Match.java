package edu.co.icesi.introspringboot.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "match_game")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "match_date")
    private LocalDate matchDate;

    @ManyToOne
    @JoinColumn(name = "home_country_id")
    private Country homeCountry;

    @OneToMany
    private List<Country> awayCountry;

    private String stadium;

    public Match() {
    }

    public Match(LocalDate matchDate, Country homeCountry, List<Country> awayCountry, String stadium) {
        this.matchDate = matchDate;
        this.homeCountry = homeCountry;
        this.awayCountry = awayCountry;
        this.stadium = stadium;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getMatchDate() { return matchDate; }
    public void setMatchDate(LocalDate matchDate) { this.matchDate = matchDate; }

    public Country getHomeCountry() { return homeCountry; }
    public void setHomeCountry(Country homeCountry) { this.homeCountry = homeCountry; }

    public List<Country> getAwayCountry() { return awayCountry; }
    public void setAwayCountry(List<Country> awayCountry) { this.awayCountry = awayCountry; }

    public String getStadium() { return stadium; }
    public void setStadium(String stadium) { this.stadium = stadium; }
}
