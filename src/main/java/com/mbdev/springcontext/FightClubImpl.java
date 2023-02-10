package com.mbdev.springcontext;

@PureTransactional
public class FightClubImpl implements FightClub{

    private CombatCat loriCat;

    private CombatCat baxterCat;

    @Override
    public void fight() {
        System.out.println("First cat " + loriCat.toString());
        System.out.println("Second cat " + baxterCat.toString());

        Integer loriStrength = loriCat.getStrength();
        Integer baxterStrength = baxterCat.getStrength();
        String loriName = loriCat.getName();
        String baxterName = baxterCat.getName();

        if(loriStrength>baxterStrength){
            System.out.println(loriName + " win cat");
        } else if (baxterStrength>loriStrength) {
            System.out.println(baxterName + " win cat");
        } else System.out.println("Cats strength is same");
    }

    public void setLoriCat(CombatCat loriCat) {
        this.loriCat = loriCat;
    }

    public void setBaxterCat(CombatCat baxterCat) {
        this.baxterCat = baxterCat;
    }
}
