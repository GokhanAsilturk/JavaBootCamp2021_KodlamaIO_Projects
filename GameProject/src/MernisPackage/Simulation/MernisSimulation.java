package MernisPackage.Simulation;


import gameproject.Entities.concretes.Gamer;


public class MernisSimulation implements IpersonCheckSimulation {

    Gamer gamer;

    public MernisSimulation() {
    }

    @Override
    public boolean IfrealPerson(Gamer gamer) {

        SimulationValues simulationValues = new SimulationValues();

        if (gamer.getId().equals(simulationValues.getId())) {
            return true;

        } else {
            return false;
        }


    }


}
