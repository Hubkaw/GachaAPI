package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Materialweaponclass;
import com.gachaapi.Entity.Weaponclass;
import com.gachaapi.Repository.MaterialRepository;
import com.gachaapi.Repository.MaterialWeaponClassRepository;
import com.gachaapi.Repository.WeaponClassRepository;
import com.gachaapi.Service.interfaces.WeaponClassService;
import com.gachaapi.Utils.dev.NewMaterialWeaponClass;
import com.gachaapi.Utils.dev.NewWeaponClass;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WeaponClassServiceImpl implements WeaponClassService {

    private WeaponClassRepository weaponClassRepository;
    private MaterialWeaponClassRepository mwcRepository;
    private MaterialRepository materialRepository;

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

    @Override
    public void addMaterial(NewMaterialWeaponClass newMaterialWeaponClass) {
        Materialweaponclass mwc = new Materialweaponclass();
        mwc.setWeaponClasses(weaponClassRepository.getReferenceById(newMaterialWeaponClass.getWeaponClassId()));
        mwc.setMaterial(materialRepository.getReferenceById(newMaterialWeaponClass.getMaterialId()));
        mwc.setBaseAmount(newMaterialWeaponClass.getBaseAmount());
        mwc.setPerLvlAmount(newMaterialWeaponClass.getPerLvlAmount());
        mwcRepository.save(mwc);
    }

    @Override
    public void deleteMaterial(int id) {
        mwcRepository.deleteById(id);
    }

    @Override
    public Weaponclass getById(int id) {
        return weaponClassRepository.getReferenceById(id);
    }
}
