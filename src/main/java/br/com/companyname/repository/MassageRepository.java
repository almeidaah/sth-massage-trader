package br.com.companyname.repository;

import br.com.companyname.model.Massage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MassageRepository extends MongoRepository<Massage, String>{

    @Query(value= "{ 'login.email' : { $regex: '.*?0.*' } }")
    Massage findByLogin(String email);

    @Query(value= "{ 'login.email' : { $regex: '.*?0.*' } }")
    List<Massage> findAllByLogin(String email);
}
