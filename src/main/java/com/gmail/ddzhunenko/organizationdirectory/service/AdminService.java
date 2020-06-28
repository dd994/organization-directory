package com.gmail.ddzhunenko.organizationdirectory.service;

import com.gmail.ddzhunenko.organizationdirectory.entity.Position;

public interface AdminService {

    //--------------- position service ----------------//

    void savePosition(Position position);
    void deletePosition(Position position);
    void getPosition(Position position);
    void editPosition(Position position);

}


//Интерфейс администрирования должен обеспечивать
//– ведение справочников подразделений и должностей;
//– просмотр информации о сотрудниках;
//– добавление и редактирование информации о сотрудниках