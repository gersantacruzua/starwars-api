package com.starwars.repository;

import com.starwars.model.Planet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;

    @Test
    public void should_find_by_name() throws Exception {
        Planet alderaan = planetRepository.findByName("Alderaan");
        assertThat(alderaan.getName(), is("Alderaan"));
    }

    @Test
    public void should_find_all_paging(){
        PageRequest page = new PageRequest(0, 2);
        Page<Planet> all = planetRepository.findAll(page);

        /*Sort sort = new Sort(Sort.Direction.ASC, "episodeId")
             .and(new Sort(Sort.Direction.DESC, "releaseDate"));
        planetRepository.findAll(sort);
        System.out.print("test");*/
    }

}
