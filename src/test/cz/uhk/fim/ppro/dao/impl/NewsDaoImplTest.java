package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.INewsDao;
import cz.uhk.fim.ppro.model.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"test-context.xml"})
public class NewsDaoImplTest {

    @Autowired
    private INewsDao newsDao;

    @Test
    public void findAllNews() {
        List<News> news = newsDao.findAllNews();
        assertTrue(!news.isEmpty());
    }

    @Test
    public void findNewsByName() {
        List<News> news = newsDao.findNewsByName(null);
        assertTrue(!news.isEmpty());

        news = newsDao.findNewsByName("h");
        assertTrue(!news.isEmpty());

        news = newsDao.findNewsByName("f");
        assertTrue(news.isEmpty());
    }
}