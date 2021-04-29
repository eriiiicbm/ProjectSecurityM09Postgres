package m09_project_spingsecurity.demo.repository;

import m09_project_spingsecurity.demo.model.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends CrudRepository<Usuari, String> {

}
