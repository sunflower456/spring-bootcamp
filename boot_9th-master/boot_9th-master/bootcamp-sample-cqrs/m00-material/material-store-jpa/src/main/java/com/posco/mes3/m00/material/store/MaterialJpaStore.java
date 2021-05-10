package com.posco.mes3.m00.material.store;

import com.posco.mes3.m00.material.entity.Material;
import com.posco.mes3.m00.material.store.jpo.MaterialJpo;
import com.posco.mes3.m00.material.store.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class MaterialJpaStore implements MaterialStore {
    //
    @Autowired
    MaterialRepository materialRepository;

    @Override
    public void create(Material material) {
        //
        materialRepository.save(new MaterialJpo(material));
    }

    @Override
    public Material retrieve(String id) {
        //
        Optional<MaterialJpo> materialJpo = materialRepository.findById(id);
        if (!materialJpo.isPresent()) {
            throw new NoSuchElementException(String.format("Material(%s) is not found.", id));
        }

        return materialJpo.get().toDomain();
    }

    @Override
    public void update(Material material) {
        //
        materialRepository.save(new MaterialJpo(material));
    }

    @Override
    public void delete(Material material) {
        //
        materialRepository.delete(new MaterialJpo(material));
    }

    @Override
    public boolean existsById(String id) {
        //
        return materialRepository.existsById(id);
    }

    @Override
    public List<Material> retrieveAll() {
        //
        List<Material> materials = new ArrayList<>();
        List<MaterialJpo> materialJpos = materialRepository.findAll();
        for (MaterialJpo materialJpo: materialJpos) {
            materials.add(materialJpo.toDomain());
        }
        return materials;
    }

}
