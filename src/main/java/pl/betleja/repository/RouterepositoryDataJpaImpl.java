package pl.betleja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.betleja.model.Route;

@Repository
public interface RouterepositoryDataJpaImpl extends JpaRepository<Route, Long> {


}
