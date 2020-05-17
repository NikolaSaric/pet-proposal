package com.petproposal.petproposal.service;

import com.petproposal.petproposal.model.Animal;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.petproposal.petproposal.converter.AnimalConverter;
import com.petproposal.petproposal.dto.AnimalDto;
import com.petproposal.petproposal.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    private final AnimalConverter animalConverter;

    private KieContainer kieContainer;

    public AnimalService(AnimalRepository animalRepository, AnimalConverter animalConverter, KieContainer kieContainer) {
        this.animalRepository = animalRepository;
        this.animalConverter = animalConverter;
        this.kieContainer = kieContainer;
    }

    public AnimalDto findById(Long id) {
        return animalConverter.toDto(animalRepository.getOne(id));
    }

    public AnimalDto findByName(String name) {
        return animalConverter.toDto(animalRepository.findByName(name).get());
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public AnimalDto save(AnimalDto dto) {
        return animalConverter.toDto(animalRepository.save(animalConverter.toEntity(dto)));
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }

    public String proposeAnimal(AnimalDto userInfo) {
        List<Animal> animals = animalRepository.findAll();



        for (Animal a : animals) {
            KieSession kieSession = kieContainer.newKieSession();
            kieSession.setGlobal("animal", a);
            kieSession.insert(userInfo);
            kieSession.fireAllRules();
            kieSession.dispose();

            System.out.println(a.getName() + a.getResult());
        }

        return  "Test!";
    }
}
