package gameproject.business.abstracts;

import gameproject.Entities.concretes.Gamer;

public interface IGamerService {

void add(Gamer gamer) throws Exception;
void delete(Gamer gamer) throws Exception;
void update(Gamer gamer) throws Exception;




}
