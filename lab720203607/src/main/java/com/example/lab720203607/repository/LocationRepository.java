package com.example.lab720203607.repository;

import com.example.lab720203607.dto.EquiposxPais;
import com.example.lab720203607.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {


    @Query(value = "SELECT l.Country as Country, count(*) as Cantidad\n" +
            "from device d\n" +
            "inner join site s on (d.SiteID = s.SiteID)\n" +
            "inner join location l on (l.LocationID = s.LocationID)\n" +
            "group by l.Country", nativeQuery = true)
    List<EquiposxPais> equiposxpais();
}
