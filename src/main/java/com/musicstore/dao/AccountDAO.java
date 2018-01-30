package com.musicstore.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Account;
@Repository
public interface AccountDAO extends CrudRepository<Account, Integer>{
      @Query("select u from Account u where u.username = ?1")
      public Account findByUserName(String username);
      @Query("SELECT COUNT(e)>0 FROM Account e WHERE e.username=?1")
      public boolean existsByUsername(String username);
      @Modifying
      @Query("update Account u set u.token = ?2 where u.username=?1")
      public void updateToken(String username, String token);
}
 