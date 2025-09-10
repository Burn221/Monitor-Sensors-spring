package ru.nikitanevmyvaka.monitorsensors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nikitanevmyvaka.monitorsensors.model.Sensor;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {

    @Query("""
  select s from Sensor s
  where lower(s.name) like lower(concat('%', :name, '%'))
""")
    List<Sensor> searchByNamePartially(@Param("name") String name);



    @Query("""
    select s from Sensor s
    where lower(s.model) like lower(concat('%', :model, '%'))
""")
    List<Sensor> searchByModelPartially(@Param("model") String model);



}
