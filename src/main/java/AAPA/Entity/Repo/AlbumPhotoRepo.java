/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AAPA.Entity.Repo;

import AAPA.Entity.AlbumPhoto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author youssef
 */
public  interface AlbumPhotoRepo extends CrudRepository<AlbumPhoto, Long>{
     
    public List<AlbumPhoto> findAll();
    public List<AlbumPhoto> findOneByIdPubAlb(Long idPubAlb);
     

}
