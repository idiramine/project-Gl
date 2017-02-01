/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity.Repo;

import AAPA.Entity.Donations;
import AAPA.Entity.Files;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author amine
 */
public interface DonationsRepo extends CrudRepository<Donations, Long> {

    //public List<Donations> findAllOrderBydonationDate();
    public List<Donations> findAll();
    public List<Donations> findByfile(Files file);
    
}
