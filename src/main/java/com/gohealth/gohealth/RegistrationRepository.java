package com.gohealth.gohealth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by rameshkulkarni on 9/4/17.
 */
@RepositoryRestResource
public interface RegistrationRepository extends CrudRepository<Registration,Long>
{
}
