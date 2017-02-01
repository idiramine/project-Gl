/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity.Repo;

import AAPA.Entity.Beneficiary;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author amine
 */
public interface BeneficiaryRepo extends CrudRepository<Beneficiary, Long> {

    public List<Beneficiary> findAll();
    
}
