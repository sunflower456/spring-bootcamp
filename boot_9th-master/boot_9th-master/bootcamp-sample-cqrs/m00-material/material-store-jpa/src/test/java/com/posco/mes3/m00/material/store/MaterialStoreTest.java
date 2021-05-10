package com.posco.mes3.m00.material.store;

import com.posco.mes3.m00.material.entity.Material;
import org.apache.commons.lang.time.StopWatch;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MaterialApp.class)
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MaterialStoreTest {
    //
    @Autowired
    MaterialStore materialStore;

    Material material;

    @Before
    public void before() {
        //
        for (int i=0; i<1000; i++) {
            material = Material.sample();
            materialStore.create(material);
        }
    }

    @Test
    public void testCreate() {
        //
        StopWatch stopWatch = new StopWatch();

        for (int i=0; i<10; i++) {
            stopWatch.reset();
            stopWatch.start();
            materialStore.retrieveAll();
            stopWatch.stop();
            System.out.println(i + "---> " + stopWatch.getTime());
        }
    }
}
