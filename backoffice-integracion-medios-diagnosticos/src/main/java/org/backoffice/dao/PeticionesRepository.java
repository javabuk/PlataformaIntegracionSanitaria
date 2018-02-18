package org.backoffice.dao;

import org.backoffice.model.PsiSolicitudesSol;
import org.backoffice.model.Sistema;
import org.springframework.data.repository.CrudRepository;

public interface PeticionesRepository extends CrudRepository<PsiSolicitudesSol, String> {

}
