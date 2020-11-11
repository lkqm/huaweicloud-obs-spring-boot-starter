# huaweicloud-obs-spring-boot-starter

huaweicloud-sdk-java-obs spring boot starter.

Supports: JDK 1.7, spring-boot 1.5.x, spring-boot 2.x

## Quick
1. Add dependency
    ```
   <dependency>
       <groupId>com.github.lkqm</groupId>
       <artifactId>huaweicloud-obs-spring-boot-starter</artifactId>
       <version>${version}</version>
   </dependency>
    ```

2. Config property
    ```
   huaweicloud.obs.endpoint=@endpoint                    # service (MUST)
   huaweicloud.obs.access-key-id=@keyId                  # access key id
   huaweicloud.obs.access-key-secret=@secret             # access key secret
   huaweicloud.obs.security-token=@token                 # auth token
   huaweicloud.obs.config.XXX                            # other configuration，see `ObsConfiguration`
   ```

3. Use
    ```
    @Resource
    ObsClient obsClient;

    @Test
    public void test() {
        obsClient.putObject(bucketName, objectKey, new ByteArrayInputStream(content.getBytes("UTF-8")), null);
    }
    ```