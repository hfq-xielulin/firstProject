package com.xll.myProject.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.timevale.esign.sdk.tech.bean.result.Result;
import com.timevale.esign.sdk.tech.service.EsignsdkService;
import com.timevale.esign.sdk.tech.service.factory.EsignsdkServiceFactory;
import com.timevale.tech.sdk.bean.ProjectConfig;

/**
 * 
* @ClassName: ECAConfig 
* @Description: 初始化E签宝
* @author: xielulin
* @date 2017年12月9日 下午4:37:26
 */
@Component
public class ECAConfig {
	@Value("${hfq.ca.supplier.eqb.projectId}")
	private String projectId;
	
	@Value("${hfq.ca.supplier.eqb.projectSecret}")
	private String projectSecret;
	
	@Value("${hfq.ca.supplier.eqb.apisUrl}")
	private String apisUrl;
	
	ProjectConfig projectConfig=new ProjectConfig();
	private Logger LOG = LoggerFactory.getLogger(ECAConfig.class);
	private EsignsdkService SDK = EsignsdkServiceFactory.instance();
	
	/**
	 * 
	 * @author:xielulin 
	 * @throws Exception 
	 * @Description: 初始化操作
	 * @throws:
	 * @date:2017年12月9日 下午4:37:52
	 */
	@PostConstruct
	public void init() throws Exception {
		LOG.info("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		projectConfig.setItsmApiUrl(apisUrl);
		projectConfig.setProjectSecret(projectSecret);
		projectConfig.setProjectId(projectId);
		Result result = SDK.init(projectConfig, null, null);
		
		if(result.getErrCode()!=0) {
			//如果初始化不成功
			LOG.error(result.getMsg());
			throw new Exception(result.getMsg());
		}
	}
}
