/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity.Repo;

import AAPA.Entity.Alarm;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author amine
 */
public interface AlarmRepo extends CrudRepository<Alarm, Long> {

    public List<Alarm> findAll();
    
}
