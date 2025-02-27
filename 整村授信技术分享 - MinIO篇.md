[TOC]

# 整村授信技术分享 - MinIO篇

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在数字化转型的浪潮中，金融科技的创新应用正不断推动金融服务的高效化与智能化。整村授信项目作为我行一项重要的金融普惠举措，自上线以来已历经四个月的稳健运行，并在多个版本迭代中持续优化。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在这期间，MinIO 作为项目的核心存储解决方案，以其卓越的性能和稳定性，为文件存储与管理提供了坚实保障。在运行的四个月里，MinIO 服务始终保持零故障运行，相关文件服务也未出现任何问题，充分展现了其在高可用性、数据安全性和扩展性方面的强大优势。

## MinIO简介

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MinIO 是一个高性能、分布式对象存储系统，兼容 Amazon S3 云存储接口。它以轻量级、易部署、高性能等特点被广泛应用于企业级存储解决方案中。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MinIO 支持多种存储介质，包括本地硬盘、分布式文件系统等，并通过其强大的 API 提供数据的存储、检索和管理功能。其分布式架构设计使其能够轻松扩展，满足大规模数据存储的需求，同时保证数据的高可用性和一致性。

[MinIO官网 - 点击直达](https://min.io)

[![pE3MNAe.png](https://s21.ax1x.com/2025/02/26/pE3MNAe.png)](https://imgse.com/i/pE3MNAe)


[私有部署管理后台页面]()

[![pE3MyB8.png](https://s21.ax1x.com/2025/02/26/pE3MyB8.png)](https://imgse.com/i/pE3MyB8)

## 与FTP的对比

MinIO 相比传统 FTP 在安全性和易用性方面具有显著优势。

||MinIO|FTP|
|-|-|-|
|**加密机制**|支持服务器端加密（SSE）、客户端加密以及 TLS 1.3 自动加密功能，确保数据在传输和存储过程中的安全性。|传统 FTP 通常不支持加密，数据在传输过程中以明文形式传输，容易被窃取或篡改。|
|**访问控制**|提供细粒度的访问控制策略，包括访问控制列表（ACL）、基于角色的访问控制（RBAC）以及身份验证机制（如 JWT）。|访问控制较为简单，通常仅依赖用户名和密码，缺乏灵活的权限管理。|
|**数据完整性**|通过纠删码技术（Erasure Coding）和校验和（Checksum）确保数据的完整性和可靠性。|缺乏数据完整性校验机制，容易因网络问题导致数据损坏。|
|**部署与管理**|部署简单，仅需一个二进制文件即可启动服务，支持 Web 界面和命令行工具进行管理。|部署相对复杂，需要配置服务器和客户端，且管理界面较为繁琐。|
|**用户界面**|提供友好的 Web 管理界面，支持对象的上传、下载、删除和策略管理。|通常需要通过命令行或第三方客户端工具进行操作，用户体验较差。|
|**兼容性与集成**|全面兼容 Amazon S3 API，可以无缝集成到现有的 S3 生态系统中，减少开发和迁移成本。|兼容性较差，需要针对不同客户端和服务器进行定制化开发。|
|**扩展性**|支持分布式部署和水平扩展，可以根据业务需求动态增加节点。|扩展性较差，难以适应大规模数据存储和高并发访问需求。|

## 下载与安装

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MinIO 的开源版本采用 Apache License 2.0，这是一个非常宽松的开源许可证，允许用户自由使用、修改和分发 MinIO。

[官方下载页 - 点击直达](https://min.io/open-source/download?platform=kubernetes)

[![pE3MXC9.png](https://s21.ax1x.com/2025/02/26/pE3MXC9.png)](https://imgse.com/i/pE3MXC9)

[安装]()

Minio的官方下载页面提供了各个平台的安装示例，如下图所示：

[![pE3Mxjx.png](https://s21.ax1x.com/2025/02/26/pE3Mxjx.png)](https://imgse.com/i/pE3Mxjx)

以linux为例，实际安装步骤如下：

+ 将下载的可执行文件上传至服务器上指定目录上，例如：
  
```bash
/home/tongweb/minio/
```

+ 更改minio可执行文件的权限

```bash
chmod +x minio
```

+ 为了方便启动，编写一个sh脚本来进行启动:
  
```bash
vim start_minio.sh
```

```bash
# 设置管理员登录名
export MINIO_ROOT_USER=admin
# 设置管理员密码
export MINIO_ROOT_PASSWORD=admin123
# 后台启动minio服务
# server - 以minio服务端启动
# /home/tongweb/minio/minio-data 数据的挂载路径
# --console-address 指定控制台的端口
nohup ./mino server /home/tongweb/minio/minio-data --console-address “:9001” > minio.log 2>&1 &
echo “Minio started in background, check logs in minio.log”
```

[配置]()

浏览器访问ip:9001，登录之后选择Access keys，点击Create access key，如下图所示：

[![pE3QPED.png](https://s21.ax1x.com/2025/02/26/pE3QPED.png)](https://imgse.com/i/pE3QPED)

点击Create按钮，即可创建access key和secret key用来进行api调用。如下图所示：

[![pE3QACd.png](https://s21.ax1x.com/2025/02/26/pE3QACd.png)](https://imgse.com/i/pE3QACd)

## MinIO的核心概念

### 存储桶（bucket）
> 定义：存储桶是 MinIO 中用于存储对象的容器，类似于文件系统中的“文件夹”。

特点：
+ 每个存储桶可以包含多个对象。
+ 存储桶名称在 MinIO 集群中必须是唯一的。
+ 存储桶可以设置访问权限（如公开读、私有访问等）。
+ 存储桶可以跨多个存储节点分布数据，支持高可用性和扩展性。


### 对象（object）
>定义：对象是存储在存储桶中的实际数据单元，类似于文件系统中的“文件”。

特点：
+ 对象可以是任何类型的数据，如文本文件、图片、视频、二进制文件等。
+ 每个对象都有一个唯一的名称（Key），用于在存储桶中标识该对象。
+ 对象可以带有元数据（Metadata），用于描述对象的属性（如内容类型、大小等）。
+ 对象可以被上传、下载、删除或更新。

## 整村授信项目中的使用场景

### 客户经理通过微信小程序对客户进行图像采集

+ 在这一场景中，客户经理利用微信小程序的便捷性，对客户的相关证件和资料进行高精度图像采集。

+ 采集后的图像文件将通过直接存储至分布式对象存储系统 MinIO 中。系统将自动生成唯一的对象标识符`objectId`，并将其记录至数据库，以便后续的快速检索和管理。

+ 在此过程中，图像文件以`MultipartFile`类型接收，而返回的`objectId` 则为 `String` 类型，确保数据的高效处理和存储。

### 客户通过安心签线上签署合同后，下载PDF合同文件

+ 在整村授信项目中，客户通过安心签平台完成征信查询授权书和贷款合同的线上签署。

+ 安心签平台提供 API 接口，能够以字节数组`byte[]`的形式返回电子合同的文件流。

+ 整村授信的后台系统将通过API接口获取这些文件流，并将其存储至 MinIO 分布式存储系统中。存储完成后，系统将生成唯一的对象标识符`objectId`，并同步记录至数据库。

### 将客户的影像资料及PDF合同文件上传至行内的影像平台

+ 整村授信的后台需要定时把客户经理采集的客户影像文件和签署完毕的电子合同文件上传至行内的影像平台并获得影像批次号，以供行内其他系统共享使用。

## 系统集成

+ `pom.xml` 引入依赖
```xml
<dependency>
    <groupId>io.minio</groupId>
    <artifactId>minio</artifactId>
    <version>8.5.17</version>
</dependency>
```

+ `application.yml`新增MinIO配置
```yaml
minio:
    endpoint: http://10.8.160.112:9000 # minio的服务地址
    access-key: ********** # 登录minio的控制台进行获取
    secret-key: ********** # 登录minio的控制台进行获取
    bucket: ifmp # 默认的存储桶
```

+ 创建`MinioProperties`类来获取`application.yml`文件中的配置
```java
@Configuration
@ConfigurationProperties(prefix = “minio”)
@Getter
@Setter
public class MinioProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucket;
}
```

+ 创建`MinioConfig`配置类声明`MinioClient`
```java
@Configuration
public class MinioConfig {

    @Autowired
    private MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient(){
        return MinioClient.builder()
                    .endpoint(minioProperties.getEndpoint())
                    .credentials(
                        minioProperties.getAccessKey(),
                        minioProperties.getSecretKey())
                    .build();
    }
}
```

## 系统使用

+ 创建`MinioUtil`工具类，提供公用方法
```java

@Slf4j
@Component
public class MinioUtil {
    /**
     * 注入之前定义的minioClient
     */
    @Autowired
    private MinioClient minioClient;

    /**
     * 注入之前定义的minioProperties
     */
    @Autowired
    private MinioProperties minioProperties;

    /**
     * 此方法将在系统启动时执行
     * 判断有没有指定的默认bucket，没有的创建，有则忽略。
     */
    @PostConstruct
    public void createBucketIfNotExist(){
        try {
            // 检查bucket是否已经存在
            boolean bucketExists = minioClient.bucketExists(
            BucketExistsArgs.builder()
                .bucket(minioProperties.getBucket())
                .build()
            );
            // bucket不存在则调用sdk创建
            if (!bucketExists) {
                minioClient.makeBucket(
                    MakeBucketArgs.builder()
                        .bucket(minioProperties.getBucket())
                        .build()
                );
            }
            log.info("bucket:ifmp已经存在，跳过创建");
        } catch (Exception e) {
            throw new RuntimeException("minio 芭比Q了", e);
        }
    }

    /**
     * 调用minio的sdk进行上传
     */
    public String upload(MultipartFile file) throws Exception{
        String objectName = buildObjectName(file);
        InputStream inputStream = file.getInputStream();
        minioClient.putObject(
            PutObjectArgs.builder()
                .bucket(minioProperties.getBucket())
                .object(objectName)
                .contentType(file.getContentType())
                .stream(inputStream, inputStream.available(), -1)
                .build()
        );
        return objectName;
    }

    /**
     * 构造对象名称，格式为 年/月/日/uuid+源文件拓展名
     */ 
    private String buildObjectName(MultipartFile file){
        String objectId = IdUtil.simpleUUID();
        String originalFileName = file.getOriginalFilename() == null ? "" : file.getOriginalFilename();
        String extension = originalFileName.substring(file.getOriginalFilename().lastIndexOf("."));
        return createPrefix() + objectId + extension;
    }

    private String createPrefix() {
        LocalDateTime now = LocalDateTime.now();
        return now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth() + "/";
    }

    /**
     * 获取文件预览链接方法
     * 此方法生成的url链接经过了安全认证和防篡改签名，有效期为24小时
     * 可在浏览器中直接打开进行文件的查看
     * 也可放在前端<img>标签或者<embed>标签的url属性，实现文件的在线预览
     */
    public String getPreviewUrl(String objectId) throws Exception{
        return minioClient.getPresignedObjectUrl(
            GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(minioProperties.getBucket())
                .object(objectId)
                .expiry(1, TimeUnit.DAYS)
                .build()
        );
    }
}
```

## 生产环境的分布式部署

+ 在整村授信项目中，MinIO 服务采用分布式架构，部署于三个独立的物理节点，每个节点均位于不同的物理服务器上。

+ 通过共享同一块 NAS（网络附加存储）盘的目录，MinIO 能够实现无缝的分布式存储，无需额外配置即可自动同步数据，确保高可用性和数据一致性。

+ 这种架构不仅提升了系统的扩展性和容错能力，还通过分布式存储技术优化了数据的读写性能，为整村授信项目提供了高效、可靠且极具前瞻性的存储解决方案。

## 总结

通过上述内容的详细介绍，我们可以看到 MinIO 在整村授信项目中发挥了至关重要的作用。作为核心存储解决方案，MinIO 不仅凭借其高性能、高可用性和强大的扩展性满足了项目对海量数据存储的需求，还通过其先进的安全机制和灵活的管理功能，为数据的安全性和完整性提供了坚实的保障。

在与传统 FTP 的对比中，MinIO 显著的优势使其成为现代企业级存储的首选方案。其简单易用的部署方式、友好的管理界面以及与 Amazon S3 的无缝兼容性，极大地降低了开发和运维成本，提升了项目的整体效率。

在整村授信项目中，MinIO 的应用场景涵盖了从客户资料的图像采集、电子合同的签署到影像文件的上传等多个环节。通过与微信小程序、安心签平台以及行内影像平台的深度集成，MinIO 为项目提供了高效、稳定且安全的存储服务，确保了数据的快速处理和便捷管理。

此外，MinIO 的分布式架构设计为项目的生产环境提供了强大的容错能力和扩展性。通过在多个物理节点上的部署，MinIO 实现了数据的自动同步和高可用性，进一步优化了数据的读写性能，为整村授信项目的长期稳定运行奠定了坚实基础。