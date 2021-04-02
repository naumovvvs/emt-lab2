package mk.ukim.finki.emt.lab2.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Country {
    @Id
    private Long id;

    private String name;
    private String continent;
}
