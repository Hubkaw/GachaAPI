package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Weaponclass;
import com.gachaapi.Repository.WeaponClassRepository;
import com.gachaapi.Service.interfaces.WeaponClassService;
import com.gachaapi.Utils.dev.NewWeaponClass;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WeaponClassServiceImpl implements WeaponClassService {

    private WeaponClassRepository weaponClassRepository;
    @Override
    public List<Weaponclass> getAll() {
        return weaponClassRepository.findAll();
    }

    @Override
    public void create(NewWeaponClass newWeaponClass) {
        Weaponclass weaponclass = new Weaponclass();
        weaponclass.setName(newWeaponClass.getName());
        weaponclass.setShortName(newWeaponClass.getShortName());
        weaponClassRepository.save(weaponclass);
    }

    @Override
    public void delete(int id) {
        weaponClassRepository.delete(weaponClassRepository.getReferenceById(id));
    }
}
