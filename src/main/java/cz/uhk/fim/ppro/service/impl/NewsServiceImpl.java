package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.dao.INewsDao;
import cz.uhk.fim.ppro.model.News;
import cz.uhk.fim.ppro.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl extends GeneralServiceImpl<News, Integer> implements INewsService {

    @Autowired
    private INewsDao newsDao;

    @Autowired
    public NewsServiceImpl(@Qualifier("newsDaoImpl") IGeneralDao<News, Integer> generalDao) {
        super(generalDao);
    }

    @Override
    public Integer create(News news) {
        news.setAdded(new Date());

        return newsDao.create(news);
    }

    @Override
    public List<News> findAllNews() {
        return newsDao.findAllNews();
    }

    @Override
    public List<News> getNewsByName(String name) {
        return newsDao.findNewsByName(name);
    }
}
