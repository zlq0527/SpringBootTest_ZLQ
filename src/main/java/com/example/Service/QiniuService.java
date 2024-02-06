package com.example.Service;
import com.alibaba.fastjson.JSONObject;
import com.example.Utils.FileUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

/**
 * @ Author     ：赵棱泉.
 * @ Date       ：Created in 13:07 2022/3/6
 * @ Description：
 */
//七牛云存储Service配置
@Service
public class QiniuService {
	private static final Logger logger = LoggerFactory.getLogger(QiniuService.class);

	// 设置好账号的ACCESS_KEY和SECRET_KEY
	String ACCESS_KEY = "mZ7yXuQ7hoQDji0gvMVsXlsrxerJy71TNwhRmMBn";
	String SECRET_KEY = "M-sYJDM6-4ThPT_L--pQqXUB_Z_AXA0RHn2VnT9B";
	// 要上传的空间
	String bucketname = "yl0717";

	// 密钥配置
	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	// 构造一个带指定Zone对象的配置类,不同的七云牛存储区域调用不同的zone
//	Region region = new RegionGroup();
	Configuration cfg = new Configuration(Region.autoRegion());
	// ...其他参数参考类注释
	UploadManager uploadManager = new UploadManager(cfg);

	// 测试域名，只有30天有效期
	private static String QINIU_IMAGE_DOMAIN = "http://r8b4dh9j5.bkt.clouddn.com/";

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	public String saveImage(MultipartFile file) throws IOException {
		try {
			int dotPos = file.getOriginalFilename().lastIndexOf(".");
			if (dotPos < 0) {
				return null;
			}
			String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
			// 判断是否是合法的文件后缀
			if (!FileUtil.isFileAllowed(fileExt)) {
				return null;
			}
			String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
			// 调用put方法上传
			Response res = uploadManager.put(file.getBytes(), fileName, getUpToken());
			// 打印返回的信息
			if (res.isOK() && res.isJson()) {
				// 返回这张存储照片的地址
				return QINIU_IMAGE_DOMAIN + JSONObject.parseObject(res.bodyString()).get("key");
			} else {
				logger.error("七牛异常:" + res.bodyString());
				return null;
			}
		} catch (QiniuException e) {
			// 请求失败时打印的异常的信息
			logger.error("七牛异常:" + e.getMessage());
			return null;
		}
	}
}

