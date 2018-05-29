package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.model.Place;
import cz.uhk.fim.ppro.service.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl extends GeneralServiceImpl<Place, Integer> implements IPlaceService {

    @Autowired
    public PlaceServiceImpl(@Qualifier("placeDaoImpl") IGeneralDao<Place, Integer> generalDao) {
        super(generalDao);
    }
}
