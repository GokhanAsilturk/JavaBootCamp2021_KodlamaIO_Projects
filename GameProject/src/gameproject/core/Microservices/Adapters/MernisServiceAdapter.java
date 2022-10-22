package gameproject.core.Microservices.Adapters;






import MernisPackage.Simulation.MernisSimulation;
import gameproject.Entities.concretes.Gamer;
import gameproject.core.abstracts.IPersonCheckService;

public class MernisServiceAdapter implements IPersonCheckService {

    @Override
    public boolean CheckPerson(Gamer gamer) throws Exception {
        MernisSimulation client = new MernisSimulation();
        return client.IfrealPerson(gamer);
    }
}
