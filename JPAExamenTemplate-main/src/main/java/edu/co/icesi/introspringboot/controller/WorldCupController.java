package edu.co.icesi.introspringboot.controller;

import edu.co.icesi.introspringboot.entity.Club;
import edu.co.icesi.introspringboot.entity.Country;
import edu.co.icesi.introspringboot.entity.Match;
import edu.co.icesi.introspringboot.entity.Player;
import edu.co.icesi.introspringboot.repository.ClubRepository;
import edu.co.icesi.introspringboot.repository.CountryRepository;
import edu.co.icesi.introspringboot.repository.MatchRepository;
import edu.co.icesi.introspringboot.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/worldcup")
public class WorldCupController {

    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final ClubRepository clubRepository;
    private final CountryRepository countryRepository;


    public WorldCupController(PlayerRepository playerRepository,
                              MatchRepository matchRepository,
                              ClubRepository clubRepository,
                              CountryRepository countryRepository
                              ) {
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.clubRepository = clubRepository;
        this.countryRepository = countryRepository;
    }

    // Jugadores que han jugado históricamente en un club específico.
    @GetMapping("/ej1")
    public List<Player> ej1(@RequestParam String clubName){
        return playerRepository.findDistinctByPlayerClubs_Club_Name(clubName);
    }

    // Jugadores de un país que han jugado en un club específico, limitado a 5.
    @GetMapping("/ej2")
    public List<Player> ej2(@RequestParam String countryName, @RequestParam String clubName){
        return playerRepository.findTop5DistinctByCountry_NameAndPlayerClubs_Club_Name(countryName, clubName);
    }

    // Partidos donde el país local tiene jugadores que pertenecen actualmente a un club específico.
    @GetMapping("/ej3")
    public List<Match> ej3(@RequestParam String clubName){
        return matchRepository.findDistinctByHomeCountry_Players_PlayerClubs_Club_NameAndHomeCountry_Players_PlayerClubs_EndDateIsNull(clubName);
    }

    // Clubes actuales de los jugadores que participaron en un partido específico.
    @GetMapping("/ej4")
    public List<Club> ej4(@RequestParam Integer matchId){
        return clubRepository
                .findDistinctByPlayerClubs_EndDateIsNullAndPlayerClubs_Player_Country_HomeMatches_IdOrPlayerClubs_EndDateIsNullAndPlayerClubs_Player_Country_AwayMatches_Id(
                        matchId,
                        matchId
                );
    }

    @GetMapping("/ej5")
    public Iterable<Country> ej5(){
        return countryRepository.findTop15DistinctByOrderByPlayers_FifaScoreDesc();
    }

}
