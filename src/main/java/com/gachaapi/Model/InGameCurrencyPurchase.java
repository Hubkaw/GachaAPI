package com.gachaapi.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class InGameCurrencyPurchase {
    private int idigcp;
    private int volume;
    private Object price;
    private Collection<PlayerPurchase> playerPurchasesByIdigcp;

    @Id
    @Column(name = "IDIGCP", nullable = false)
    public int getIdigcp() {
        return idigcp;
    }

    public void setIdigcp(int idigcp) {
        this.idigcp = idigcp;
    }

    @Basic
    @Column(name = "Volume", nullable = false)
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "Price", nullable = false)
    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InGameCurrencyPurchase that = (InGameCurrencyPurchase) o;
        return idigcp == that.idigcp && volume == that.volume && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idigcp, volume, price);
    }

    @OneToMany(mappedBy = "inGameCurrencyPurchaseByInGameCurrencyPurchaseIdigcp")
    public Collection<PlayerPurchase> getPlayerPurchasesByIdigcp() {
        return playerPurchasesByIdigcp;
    }

    public void setPlayerPurchasesByIdigcp(Collection<PlayerPurchase> playerPurchasesByIdigcp) {
        this.playerPurchasesByIdigcp = playerPurchasesByIdigcp;
    }
}
