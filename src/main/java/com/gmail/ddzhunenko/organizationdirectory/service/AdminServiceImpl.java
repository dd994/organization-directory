package com.gmail.ddzhunenko.organizationdirectory.service;

import com.gmail.ddzhunenko.organizationdirectory.entity.Position;
import com.gmail.ddzhunenko.organizationdirectory.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    PositionRepository positionRepository;



    //--------------- position service ----------------//

    @Override
    public void savePosition (Position position){
        positionRepository.save(position);
    }

    @Override
    public void deletePosition(Position position){
        positionRepository.delete(position);
    }

    @Override
    public void getPosition(Position position) {

    }

    @Override
    public void editPosition(Position position) {

    }


}
