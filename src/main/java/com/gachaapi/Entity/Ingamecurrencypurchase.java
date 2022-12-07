package com.gachaapi.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Ingamecurrencypurchase {
    private int idigcp;
    private int volume;
    private BigDecimal price;
    private Collection<PlayerPurchase> playerPurchasesByIdigcp;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "Price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingamecurrencypurchase that = (Ingamecurrencypurchase) o;
        return idigcp == that.idigcp && volume == that.volume && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idigcp, volume, price);
    }

    @OneToMany(mappedBy = "ingamecurrencypurchaseByInGameCurrencyPurchaseIdigcp")
    public Collection<PlayerPurchase> getPlayerPurchasesByIdigcp() {
        return playerPurchasesByIdigcp;
    }

    public void setPlayerPurchasesByIdigcp(Collection<PlayerPurchase> playerPurchasesByIdigcp) {
        this.playerPurchasesByIdigcp = playerPurchasesByIdigcp;
    }
}
