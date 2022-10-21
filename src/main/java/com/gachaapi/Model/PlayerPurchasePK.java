package com.gachaapi.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PlayerPurchasePK implements Serializable {
    private int playerIdPlayer;
    private int paymentMethodIdPaymentMethod;
    private int inGameCurrencyPurchaseIdigcp;

    @Column(name = "Player_IdPlayer", nullable = false)
    @Id
    public int getPlayerIdPlayer() {
        return playerIdPlayer;
    }

    public void setPlayerIdPlayer(int playerIdPlayer) {
        this.playerIdPlayer = playerIdPlayer;
    }

    @Column(name = "PaymentMethod_IDPaymentMethod", nullable = false)
    @Id
    public int getPaymentMethodIdPaymentMethod() {
        return paymentMethodIdPaymentMethod;
    }

    public void setPaymentMethodIdPaymentMethod(int paymentMethodIdPaymentMethod) {
        this.paymentMethodIdPaymentMethod = paymentMethodIdPaymentMethod;
    }

    @Column(name = "InGameCurrencyPurchase_IDIGCP", nullable = false)
    @Id
    public int getInGameCurrencyPurchaseIdigcp() {
        return inGameCurrencyPurchaseIdigcp;
    }

    public void setInGameCurrencyPurchaseIdigcp(int inGameCurrencyPurchaseIdigcp) {
        this.inGameCurrencyPurchaseIdigcp = inGameCurrencyPurchaseIdigcp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerPurchasePK that = (PlayerPurchasePK) o;
        return playerIdPlayer == that.playerIdPlayer && paymentMethodIdPaymentMethod == that.paymentMethodIdPaymentMethod && inGameCurrencyPurchaseIdigcp == that.inGameCurrencyPurchaseIdigcp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerIdPlayer, paymentMethodIdPaymentMethod, inGameCurrencyPurchaseIdigcp);
    }
}
