package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.RespModule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespModuleRepository extends CrudRepository<RespModule,Long> {

}
