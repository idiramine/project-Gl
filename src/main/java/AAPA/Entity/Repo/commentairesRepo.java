/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity.Repo;

import AAPA.Entity.commentaires;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author youssef
 */
public interface commentairesRepo extends CrudRepository<commentaires, Long>{
      @Override
    public List<commentaires> findAll();
}
