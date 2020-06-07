package tech.espublic.problem2.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Starship entity
 */
@Getter
@Setter
@Entity
@Table(name = "startship")
public class Starship extends CommonDomain implements Serializable {

    private static final long serialVersionUID = -4955866298661212392L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "cost_in_credits")
    private String costInCredits;

    @Column(name = "length")
    private String length;

    @Column(name = "max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @Column(name = "crew")
    private String crew;

    @Column(name = "passengers")
    private String passengers;

    @Column(name = "cargo_capacity")
    private String cargoCapacity;

    @Column(name = "consumables")
    private String consumables;

    @Column(name = "hyperdrive_rating")
    private String hyperdriveRating;

    @Column(name = "MGLT")
    private String MGLT;

    @Column(name = "starship_class")
    private String starshipClass;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "starship")
    private List<StarshipPeople> starshipPeopleList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "starship")
    private List<FilmStarship> filmStarshipList = new ArrayList<>();
}
