package m09_project_spingsecurity.demo.repository;

import m09_project_spingsecurity.demo.model.Campeon;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriCampeones extends CrudRepository<Campeon, String> {

}
