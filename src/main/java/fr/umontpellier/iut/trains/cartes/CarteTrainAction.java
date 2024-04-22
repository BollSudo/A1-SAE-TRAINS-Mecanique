package fr.umontpellier.iut.trains.cartes;

public abstract class CarteTrainAction extends CarteTrain {

    public CarteTrainAction(String nom, int cout, int valeur) {
        super(nom, cout, valeur);
    }
    @Override
    public boolean estDeType(TypeCarte type) {
        return TypeCarte.ACTION.name().equals(type.name()) ||
                TypeCarte.TRAIN.name().equals(type.name());
    }
}
