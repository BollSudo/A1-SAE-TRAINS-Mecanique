package fr.umontpellier.iut.trains.cartes;

public class TrainDeTourisme extends CarteTrainAction {
    public TrainDeTourisme() {
        super("Train de tourisme", 4, 1);
    }

    @Override
    public int getPointVictoire() {
        return 1;
    }
}
