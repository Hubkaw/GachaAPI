package com.gachaapi.Service.impl;

import com.gachaapi.Entity.StatWeapon;
import com.gachaapi.Entity.Weapon;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.WeaponService;
import com.gachaapi.Utils.dev.NewStatWeapon;
import com.gachaapi.Utils.dev.NewWeapon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WeaponServiceImpl implements WeaponService {

    private WeaponRepository weaponRepository;
    private ElementRepository elementRepository;
    private RarityRepository rarityRepository;
    private WeaponClassRepository weaponClassRepository;
    private StatisticRepository statisticRepository;
    private StatWeaponRepository statWeaponRepository;


    @Override
    public List<Weapon> getAll() {
        return weaponRepository.findAll();
    }

    @Override
    public void create(NewWeapon newWeapon) {
        Weapon weapon = new Weapon();
        weapon.setName(newWeapon.getName());
        weapon.setElement(elementRepository.getReferenceById(newWeapon.getElementId()));
        weapon.setWeaponClass(weaponClassRepository.getReferenceById(newWeapon.getWeaponClassId()));
        weapon.setRarity(rarityRepository.getReferenceById(newWeapon.getRarityId()));
        weaponRepository.save(weapon);
    }

    @Override
    public void delete(int id) {
            weaponRepository.deleteById(id);
    }

    @Override
    public Weapon getById(int id) {
        return weaponRepository.getReferenceById(id);
    }

    @Override
    public void createStatWeapon(NewStatWeapon newStatWeapon) {
        StatWeapon statWeapon = new StatWeapon();
        statWeapon.setStat(statisticRepository.getReferenceById(newStatWeapon.getStatId()));
        statWeapon.setWeapon(weaponRepository.getReferenceById(newStatWeapon.getWeaponId()));
        statWeapon.setValue(newStatWeapon.getValue());
        statWeaponRepository.saveAndFlush(statWeapon);
    }

    @Override
    public void deleteStatWeapon(int id) {
        statWeaponRepository.deleteById(id);
    }
}
