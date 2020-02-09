package pl.altkom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.altkom.model.Route;

@Repository
public interface RouterepositoryDataJpaImpl extends JpaRepository<Route, Long> {


}
