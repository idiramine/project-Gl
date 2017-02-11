/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity.Repo;

import AAPA.Entity.Compagnon;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author amine
 */
public interface CompagnonRepo extends CrudRepository<Compagnon, Long> {

    public List<Compagnon> findAll();
    
}
