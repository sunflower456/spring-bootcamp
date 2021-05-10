package com.posco.mes3.m00.material.query.store;

import com.posco.mes3.m00.material.query.store.jpo.MaterialFlatJpo;
import com.posco.mes3.m00.material.query.model.FlatMaterial;
import com.posco.mes3.m00.material.query.store.repository.MaterialFlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class MaterialFlatJpaStore implements MaterialFlatStore {
    //

    @Autowired
    MaterialFlatRepository materialRepository;

    @Override
    public void create(FlatMaterial material) {
        //
        materialRepository.save(new MaterialFlatJpo(material));
    }

    @Override
    public FlatMaterial retrieve(String id) {
        //
        Optional<MaterialFlatJpo> materialJpo = materialRepository.findById(id);
        if (!materialJpo.isPresent()) {
            throw new NoSuchElementException(String.format("Material(%s) is not found.", id));
        }

        return materialJpo.get().toDomain();
    }

    @Override
    public void update(FlatMaterial material) {
        //
        materialRepository.save(new MaterialFlatJpo(material));
    }

    @Override
    public void delete(FlatMaterial material) {
        //
        materialRepository.delete(new MaterialFlatJpo(material));
    }

    @Override
    public boolean existsById(String id) {
        //
        return materialRepository.existsById(id);
    }
    @Override
    public List<FlatMaterial> retrieveAll() {
        //
        List<FlatMaterial> materials = new ArrayList<>();
        List<MaterialFlatJpo> materialJpos = materialRepository.findAll();
        for (MaterialFlatJpo materialJpo: materialJpos) {
            materials.add(materialJpo.toDomain());
        }
        return materials;
    }
}
