package com.gachaapi.Service.impl;

import com.gachaapi.Entity.Clazz;
import com.gachaapi.Entity.Materialclass;
import com.gachaapi.Entity.StatClass;
import com.gachaapi.Repository.*;
import com.gachaapi.Service.interfaces.ClassService;
import com.gachaapi.Utils.dev.NewClass;
import com.gachaapi.Utils.dev.NewMaterialClass;
import com.gachaapi.Utils.dev.NewStatClass;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

    private ClassRepository classRepository;
    private WeaponClassRepository weaponClassRepository;
    private StatisticRepository statisticRepository;
    private MaterialRepository materialRepository;
    private StatClassRepository statClassRepository;
    private MaterialClassRepository materialClassRepository;

    @Override
    public List<Clazz> getAll() {
        return classRepository.findAll();
    }

    @Override
    public void create(NewClass newClass) {
        Clazz clazz = new Clazz();
        clazz.setName(newClass.getName());
        clazz.setShortcut(newClass.getShortcut());
        clazz.setWeaponClass(weaponClassRepository.getReferenceById(newClass.getWeaponClassId()));
        classRepository.save(clazz);
    }

    @Override
    public void delete(int id) {
        classRepository.deleteById(id);
    }

    @Override
    public Clazz getById(int id) {
        return classRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void createStatClass(NewStatClass newStatClass) {
        StatClass sc = new StatClass();
        sc.setStat(statisticRepository.getReferenceById(newStatClass.getStatId()));
        sc.setClazz(classRepository.getReferenceById(newStatClass.getClassId()));
        sc.setValue(newStatClass.getValue());
        statClassRepository.save(sc);
    }

    @Override
    public void deleteStatClass(int id) {
        statClassRepository.deleteById(id);
    }

    @Override
    public void createMaterialClass(NewMaterialClass newMaterialClass) {
        Materialclass mc = new Materialclass();
        mc.setMaterial(materialRepository.getReferenceById(newMaterialClass.getMaterialId()));
        mc.setClazz(classRepository.getReferenceById(newMaterialClass.getClassId()));
        mc.setBaseAmount(newMaterialClass.getBaseAmount());
        mc.setPerLvlAmount(newMaterialClass.getPerLvlAmount());
        materialClassRepository.save(mc);
    }

    @Override
    public void deleteMaterialClass(int id) {
        materialClassRepository.deleteById(id);
    }
}
