package mk.ukim.finki.emt.lab2.service;

import mk.ukim.finki.emt.lab2.model.Country;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findByName(String name);
}
