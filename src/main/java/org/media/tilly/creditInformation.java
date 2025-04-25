package org.media.tilly;

public class creditInformation implements creditInformationInterface {

    int credit = 99999;

    @Override
    public double getCredit() {
        //implement DB here
        return credit;


    }

    @Override
    public void setCredit(double credit) {
        //implement database here

    }
    public void subFunds(int credit) {
        this.credit = this.credit - credit;
    }

    public void addFunds(int credit) {
        this.credit = this.credit + credit;
    }
}
