package br.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
