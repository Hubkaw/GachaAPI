package com.gachaapi.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Player_Purchase", schema = "dbo", catalog = "gacha")
@IdClass(PlayerPurchasePK.class)
public class PlayerPurchase {
    private int playerIdPlayer;
    private int paymentMethodIdPaymentMethod;
    private int inGameCurrencyPurchaseIdigcp;
    private Date boughtAt;
    private Player playerByPlayerIdPlayer;
    private PaymentMethod paymentMethodByPaymentMethodIdPaymentMethod;
    private InGameCurrencyPurchase inGameCurrencyPurchaseByInGameCurrencyPurchaseIdigcp;

    @Id
    @Column(name = "Player_IdPlayer", nullable = false)
    public int getPlayerIdPlayer() {
        return playerIdPlayer;
    }

    public void setPlayerIdPlayer(int playerIdPlayer) {
        this.playerIdPlayer = playerIdPlayer;
    }

    @Id
    @Column(name = "PaymentMethod_IDPaymentMethod", nullable = false)
    public int getPaymentMethodIdPaymentMethod() {
        return paymentMethodIdPaymentMethod;
    }

    public void setPaymentMethodIdPaymentMethod(int paymentMethodIdPaymentMethod) {
        this.paymentMethodIdPaymentMethod = paymentMethodIdPaymentMethod;
    }

    @Id
    @Column(name = "InGameCurrencyPurchase_IDIGCP", nullable = false)
    public int getInGameCurrencyPurchaseIdigcp() {
        return inGameCurrencyPurchaseIdigcp;
    }

    public void setInGameCurrencyPurchaseIdigcp(int inGameCurrencyPurchaseIdigcp) {
        this.inGameCurrencyPurchaseIdigcp = inGameCurrencyPurchaseIdigcp;
    }

    @Basic
    @Column(name = "BoughtAt", nullable = false)
    public Date getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Date boughtAt) {
        this.boughtAt = boughtAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerPurchase that = (PlayerPurchase) o;
        return playerIdPlayer == that.playerIdPlayer && paymentMethodIdPaymentMethod == that.paymentMethodIdPaymentMethod && inGameCurrencyPurchaseIdigcp == that.inGameCurrencyPurchaseIdigcp && Objects.equals(boughtAt, that.boughtAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerIdPlayer, paymentMethodIdPaymentMethod, inGameCurrencyPurchaseIdigcp, boughtAt);
    }

    @ManyToOne
    @JoinColumn(name = "Player_IdPlayer", referencedColumnName = "IdPlayer", nullable = false)
    public Player getPlayerByPlayerIdPlayer() {
        return playerByPlayerIdPlayer;
    }

    public void setPlayerByPlayerIdPlayer(Player playerByPlayerIdPlayer) {
        this.playerByPlayerIdPlayer = playerByPlayerIdPlayer;
    }

    @ManyToOne
    @JoinColumn(name = "PaymentMethod_IDPaymentMethod", referencedColumnName = "IDPaymentMethod", nullable = false)
    public PaymentMethod getPaymentMethodByPaymentMethodIdPaymentMethod() {
        return paymentMethodByPaymentMethodIdPaymentMethod;
    }

    public void setPaymentMethodByPaymentMethodIdPaymentMethod(PaymentMethod paymentMethodByPaymentMethodIdPaymentMethod) {
        this.paymentMethodByPaymentMethodIdPaymentMethod = paymentMethodByPaymentMethodIdPaymentMethod;
    }

    @ManyToOne
    @JoinColumn(name = "InGameCurrencyPurchase_IDIGCP", referencedColumnName = "IDIGCP", nullable = false)
    public InGameCurrencyPurchase getInGameCurrencyPurchaseByInGameCurrencyPurchaseIdigcp() {
        return inGameCurrencyPurchaseByInGameCurrencyPurchaseIdigcp;
    }

    public void setInGameCurrencyPurchaseByInGameCurrencyPurchaseIdigcp(InGameCurrencyPurchase inGameCurrencyPurchaseByInGameCurrencyPurchaseIdigcp) {
        this.inGameCurrencyPurchaseByInGameCurrencyPurchaseIdigcp = inGameCurrencyPurchaseByInGameCurrencyPurchaseIdigcp;
    }
}
