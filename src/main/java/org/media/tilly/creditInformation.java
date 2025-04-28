package org.media.tilly;

public class creditInformation implements creditInformationInterface {
    double funds = 2.0;

    @Override
    public double getFunds() {
        //implement DB here
        return funds;


    }

    @Override
    public void setFunds(double funds) {
        //implement database here
        this.funds = funds;

    }
    @Override
    public void subFunds(double funds) {
        this.funds = this.funds - funds;
    }
    @Override
    public void addFunds(double funds) {
        this.funds = this.funds + funds;
    }
}
