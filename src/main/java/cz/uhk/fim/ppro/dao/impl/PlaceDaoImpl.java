package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IPlaceDao;
import cz.uhk.fim.ppro.model.Place;
import org.springframework.stereotype.Repository;

@Repository
public class PlaceDaoImpl extends GeneralDaoImpl<Place, Integer> implements IPlaceDao {
}
