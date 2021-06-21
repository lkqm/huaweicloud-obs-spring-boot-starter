package com.github.lkqm.spring.huaweicloud.obs;

import com.obs.services.ObsClient;
import com.obs.services.model.ObjectMetadata;
import com.obs.services.model.PutObjectRequest;
import com.obs.services.model.PutObjectResult;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObsTest {

    @Autowired
    private ObsClient obsClient;

    @Test
    public void test() {
        PutObjectRequest request = new PutObjectRequest();
        request.setBucketName("huawei-obs-faceid-test");
        request.setObjectKey("ping.txt");
        request.setInput(new ByteArrayInputStream("pong".getBytes(StandardCharsets.UTF_8)));
        PutObjectResult result = obsClient.putObject(request);
        System.out.println(result);
    }

}
