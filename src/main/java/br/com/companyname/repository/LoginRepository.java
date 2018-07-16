package br.com.companyname.repository;

import br.com.companyname.model.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<Login, String>{

    //@Query(value= "{ 'email' : { $regex: '.*?0.*'}, 'password' : { $regex: '.*?1.*' } }")
    Login findByEmailAndPassword(String email, String password);
}
