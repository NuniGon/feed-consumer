package com.sparta.service;

import com.sparta.SpartaApplication;
import com.sparta.core.exceptions.SpartaNotFoundException;
import com.sparta.model.LoadBatch;
import com.sparta.model.Record;
import com.sparta.model.Sensor;
import com.sparta.repository.ProviderRespository;
import com.sparta.service.impl.DataProviderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpartaApplication.class)
public class DataProviderServiceImplTest {

    private static final String PROVIDER_DEFAULT = "provider";

    @Autowired
    private ProviderRespository providerRespository;

    private DataProviderService dataProviderService;

    @Before
    public void setup() {
        dataProviderService = new DataProviderServiceImpl(providerRespository);
    }

    @Before
    public void initProvider() {
        providerRespository.save(getLoadBathc());
    }

    private LoadBatch getLoadBathc() {
        return new LoadBatch(PROVIDER_DEFAULT, getRecordsList().size(), getRecordsList());
    }

    private List<Record> getRecordsList() {
        List<Sensor> sensors = getSensorList();
        Record r1 = new Record(1, Instant.now(), "tenerife", sensors);
        Record r2 = new Record(2, Instant.now(), "barcelona", sensors);
        Record r3 = new Record(3, Instant.now(), "paris", sensors);
        Record r4 = new Record(4, Instant.now(), "londres", sensors);
        Record r5 = new Record(5, Instant.now(), "ginebra", sensors);

        return Arrays.asList(r1, r2, r3, r4, r5);
    }

    private List<Sensor> getSensorList() {
        Sensor s1 = new Sensor("1", 1);
        Sensor s2 = new Sensor("2", 2);
        Sensor s3 = new Sensor("3", 3);
        Sensor s4 = new Sensor("4", 4);
        Sensor s5 = new Sensor("5", 5);


        return Arrays.asList(s1, s2, s3, s4, s5);
    }

    @Test
    public void whenExistsProvider_thenGetNumberRecords() {
        LoadBatch dto = dataProviderService.getTotalRecords(PROVIDER_DEFAULT);

        assert (dto.getTotal() == getRecordsList().size());
    }

    @Test(expected = SpartaNotFoundException.class)
    public void whenNoExistsProvider_thenExceptionThrown() {
        dataProviderService.getTotalRecords("prov");
    }

}
