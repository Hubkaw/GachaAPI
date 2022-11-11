package com.gachaapi.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Paymentmethod {
    private int idPaymentMethod;
    private String name;
    private Collection<PlayerPurchase> playerPurchasesByIdPaymentMethod;

    @Id
    @Column(name = "IDPaymentMethod", nullable = false)
    public int getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(int idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paymentmethod that = (Paymentmethod) o;
        return idPaymentMethod == that.idPaymentMethod && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPaymentMethod, name);
    }

    @OneToMany(mappedBy = "paymentmethodByPaymentMethodIdPaymentMethod")
    public Collection<PlayerPurchase> getPlayerPurchasesByIdPaymentMethod() {
        return playerPurchasesByIdPaymentMethod;
    }

    public void setPlayerPurchasesByIdPaymentMethod(Collection<PlayerPurchase> playerPurchasesByIdPaymentMethod) {
        this.playerPurchasesByIdPaymentMethod = playerPurchasesByIdPaymentMethod;
    }
}
