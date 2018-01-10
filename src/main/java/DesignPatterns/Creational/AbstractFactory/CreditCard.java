package DesignPatterns.Creational.AbstractFactory;

/**
 * Created by Saravanakumar_K05 on 11/21/2017.
 */
public abstract class CreditCard {

    protected int cardNumberLength;

    protected int cscNumber;

    public int getCardNumberLength() {
        return cardNumberLength;
    }

    public void setCardNumberLength(int cardNumberLength) {
        this.cardNumberLength = cardNumberLength;
    }

    public int getCscNumber() {
        return cscNumber;
    }

    public void setCscNumber(int cscNumber) {
        this.cscNumber = cscNumber;
    }

}

class AmexGoldCreditCard extends CreditCard {}

class AmexPlatinumCreditCard extends CreditCard {}

class VisaBlackCreditCard extends CreditCard {}

class VisaCreditCard extends CreditCard {}

class VisaGoldCreditCard extends CreditCard {}

