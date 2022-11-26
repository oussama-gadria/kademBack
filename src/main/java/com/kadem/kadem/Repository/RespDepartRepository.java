package com.kadem.kadem.Repository;

import com.kadem.kadem.Entities.RespDepart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespDepartRepository extends CrudRepository<RespDepart,Long> {
}
