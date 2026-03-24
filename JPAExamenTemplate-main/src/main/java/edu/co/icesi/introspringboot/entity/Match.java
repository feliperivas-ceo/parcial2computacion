package edu.co.icesi.introspringboot.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "away_country_id")
    private Country awayCountry;

    private String stadium;

    public Match() {
    }

    public Match(LocalDate matchDate, Country homeCountry, Country awayCountry, String stadium) {
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

    public Country getAwayCountry() { return awayCountry; }
    public void setAwayCountry(Country awayCountry) { this.awayCountry = awayCountry; }

    public String getStadium() { return stadium; }
    public void setStadium(String stadium) { this.stadium = stadium; }
}
