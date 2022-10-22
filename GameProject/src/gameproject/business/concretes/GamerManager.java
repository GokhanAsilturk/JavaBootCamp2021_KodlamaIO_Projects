package gameproject.business.concretes;


import gameproject.Entities.concretes.Gamer;
import gameproject.business.abstracts.IGamerService;
import gameproject.core.abstracts.IPersonCheckService;
import gameproject.dataAccess.abstracts.IGamerDao;

public class GamerManager implements IGamerService {

    IGamerDao gamerDao;
    IPersonCheckService personCheck;



    public GamerManager(IGamerDao gamerDao, IPersonCheckService personCheck) {
        this.gamerDao = gamerDao;
        this.personCheck = personCheck;
    }

    @Override
    public void add(Gamer gamer) throws Exception {
        if (personCheck.CheckPerson(gamer)) {
            System.out.println("Verification successful");
            gamerDao.add(gamer);

        } else {
            System.out.println("Incorrect login information! : "
                    + gamer.getFirstName() + " " + gamer.getLastName() + "\n");
        }
    }


    @Override
    public void delete(Gamer gamer) {
        gamerDao.delete(gamer);
    }

    @Override
    public void update(Gamer gamer) throws Exception {
        if(personCheck.CheckPerson(gamer)){
            gamerDao.update(gamer);
        }else {
            System.out.println("No such user was found! : "
                    + gamer.getFirstName() + " " + gamer.getLastName() + "\n");
        }


    }
}




