package com.gachaapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "player_purchase", schema = "gacha", catalog = "")
public class PlayerPurchase {
    private int id;
    private Timestamp boughtAt;
    @JsonIgnore
    private Player playerByPlayerIdPlayer;
    private Paymentmethod paymentmethodByPaymentMethodIdPaymentMethod;
    private Ingamecurrencypurchase ingamecurrencypurchaseByInGameCurrencyPurchaseIdigcp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BoughtAt", nullable = false)
    public Timestamp getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Timestamp boughtAt) {
        this.boughtAt = boughtAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerPurchase that = (PlayerPurchase) o;
        return id == that.id && Objects.equals(boughtAt, that.boughtAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, boughtAt);
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
    public Paymentmethod getPaymentmethodByPaymentMethodIdPaymentMethod() {
        return paymentmethodByPaymentMethodIdPaymentMethod;
    }

    public void setPaymentmethodByPaymentMethodIdPaymentMethod(Paymentmethod paymentmethodByPaymentMethodIdPaymentMethod) {
        this.paymentmethodByPaymentMethodIdPaymentMethod = paymentmethodByPaymentMethodIdPaymentMethod;
    }

    @ManyToOne
    @JoinColumn(name = "InGameCurrencyPurchase_IDIGCP", referencedColumnName = "IDIGCP", nullable = false)
    public Ingamecurrencypurchase getIngamecurrencypurchaseByInGameCurrencyPurchaseIdigcp() {
        return ingamecurrencypurchaseByInGameCurrencyPurchaseIdigcp;
    }

    public void setIngamecurrencypurchaseByInGameCurrencyPurchaseIdigcp(Ingamecurrencypurchase ingamecurrencypurchaseByInGameCurrencyPurchaseIdigcp) {
        this.ingamecurrencypurchaseByInGameCurrencyPurchaseIdigcp = ingamecurrencypurchaseByInGameCurrencyPurchaseIdigcp;
    }
}
