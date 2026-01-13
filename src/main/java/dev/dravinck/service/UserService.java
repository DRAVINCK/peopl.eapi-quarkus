package dev.dravinck.service;

import dev.dravinck.domain.Users;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

  @Transactional
  public Users createUser(Users user) {
    user.persist();
    return user;
  }

  public List<Users> findAll() {
    return Users.listAll();
  }

  public Users findById(UUID id) {
    Users user = Users.findById(id);
    if (user == null) {
      throw new NotFoundException("Usuário não encontrado");
    }
    return user;
  }

  @Transactional
  public void deleteById(String id) {
    boolean deleted = Users.deleteById(id);
    if (!deleted) {
      throw new NotFoundException("Usuário não encontrado para deletar");
    }
  }

  @Transactional
  public Users updateUser(UUID id, Users userData) {
    Users entity = Users.findById(id);

    if (entity == null) {
      throw new NotFoundException("Usuário não encontrado");
    }

    entity.name = userData.name;
    entity.email = userData.email;

    return entity;
  }
}