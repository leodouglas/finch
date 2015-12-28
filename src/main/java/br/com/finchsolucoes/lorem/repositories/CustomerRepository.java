package br.com.finchsolucoes.lorem.repositories;

import br.com.finchsolucoes.lorem.domains.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by leodouglas on 23/12/15.
 */
public interface CustomerRepository extends CrudRepository<Customer, String> {

    List<Customer> findByName(String name);

    List<Customer> findByIdentityDocument(String identityDocument);
}
