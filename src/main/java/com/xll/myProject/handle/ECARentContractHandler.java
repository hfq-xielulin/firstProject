package com.xll.myProject.handle;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.timevale.esign.sdk.tech.bean.OrganizeBean;
import com.timevale.esign.sdk.tech.bean.PosBean;
import com.timevale.esign.sdk.tech.bean.SignPDFFileBean;
import com.timevale.esign.sdk.tech.bean.result.AddAccountResult;
import com.timevale.esign.sdk.tech.bean.result.AddSealResult;
import com.timevale.esign.sdk.tech.bean.result.FileDigestSignResult;
import com.timevale.esign.sdk.tech.bean.seal.OrganizeTemplateType;
import com.timevale.esign.sdk.tech.bean.seal.SealColor;
import com.timevale.esign.sdk.tech.impl.constants.OrganRegType;
import com.timevale.esign.sdk.tech.impl.constants.SignType;
import com.timevale.esign.sdk.tech.service.AccountService;
import com.timevale.esign.sdk.tech.service.SealService;
import com.timevale.esign.sdk.tech.service.UserSignService;
import com.timevale.esign.sdk.tech.service.factory.AccountServiceFactory;
import com.timevale.esign.sdk.tech.service.factory.SealServiceFactory;
import com.timevale.esign.sdk.tech.service.factory.UserSignServiceFactory;

/**
 * 
* @ClassName: ECARentContractHandler 
* @Description: E签宝CA签章
* @author: xielulin
* @date 2017年12月9日 下午3:06:46
 */
@Component
public class ECARentContractHandler {
	private static Log logger = LogFactory.getLog(ECARentContractHandler.class);

	private AccountService SERVICE = AccountServiceFactory.instance();
	private UserSignService userSign = UserSignServiceFactory.instance();
	private SealService SEAL = SealServiceFactory.instance();

	/**
	 * 
	 * @author:xielulin 
	 * @Description: e签宝合同签章
	 * 分为四步：
	 * 1.初始化（只需初始化一次）
	 * 2.创建企业用户
	 * 3.创建签章
	 * 4.为合同签章
	 * @param rentContractBaseParam
	 * @return
	 * @throws Exception:
	 * @throws:
	 * @date:2017年12月9日 下午3:08:11
	 */
	public void reqCaRentContract(String code) throws Exception {

		//第一步：创建用户
		logger.info("开始创建用户");
		OrganizeBean organizeBean = new OrganizeBean();
		organizeBean.setName("这是一家公司"); //机构名称
		organizeBean.setEmail("123@123.com"); //中介邮箱
		organizeBean.setOrganCode(code); //证件号：营业执照
		organizeBean.setMobile("13320077025"); //中介联系手机号
		organizeBean.setRegType(OrganRegType.MERGE);
		//创建企业用户
		AddAccountResult accountResult = SERVICE.addAccount(organizeBean);
		logger.info("创建用户结束");
		
		//第二步：创建印章
		logger.info("开始创建印章");
		String devId = null; //开发者id
		String accountId = accountResult.getAccountId(); //账户标识

		String templateType = "STAR"; //模板类型：STAR: 标准公章 OVAL:椭圆公章
		String color = "red"; //red:红色    	bule:  蓝色 black: 黑色
		String hText = "这是一句话"; //生成公章横向文内容
		String qText = "zheshiyijuhua"; //生成公章下弦文内容

		AddSealResult addSealResult = createSealOrganize(devId, accountId, templateType, color, hText, qText);
		logger.info("创建印章结束");

		//第三步:平台用户PDF摘要签署
		logger.info("开始签署合同");
		String sealData = addSealResult.getSealData(); //签章流
		SignPDFFileBean fileBean = new SignPDFFileBean();
		String srcPdfFile = "F:\\study\\a.pdf"; //代签署合同PDF文档本地地址，含文档名
		String dstPdfFile = "F:\\study\\b.pdf"; //签署后合同PDF文档本地地址，含文档名
		fileBean.setSrcPdfFile(srcPdfFile);
		fileBean.setDstPdfFile(dstPdfFile);

		float posX = 0; //相当于关键字的y坐标偏移量
		float posY = 0; //相当于关键字的x坐标偏移量
		PosBean pos = new PosBean();
		pos.setPosType(1); //设置为关键字签署
		/*pos.setPosX(posX);
		pos.setPosY(posY);*/
		String key = "谢路林"; //关键字
		pos.setKey(key);

		String type ="Key"; //签章类型：单页   多页    骑缝   关键字
		SignType signType = null;
		if ("Single".equalsIgnoreCase(type)) {
			signType = SignType.Single;
		} else if ("Multi".equalsIgnoreCase(type)) {
			signType = SignType.Multi;
		} else if ("Edges".equalsIgnoreCase(type)) {
			signType = SignType.Edges;
		} else if ("Key".equalsIgnoreCase(type)) {
			signType = SignType.Key;
		}

		FileDigestSignResult r = userSign.localSignPDF(accountId, sealData, fileBean, pos, signType);

		logger.info("签署合同结束");
	}

	private AddSealResult createSealOrganize(String devId, String accountId, String templateType, String color,
			String hText, String qText) {

		OrganizeTemplateType template = null;
		SealColor sColor = null;
		for (OrganizeTemplateType organizeTemplateType : OrganizeTemplateType.values()) {
			if (templateType.equalsIgnoreCase(organizeTemplateType.template().disc())) {
				template = organizeTemplateType;
				break;
			}
		}
		for (SealColor sealColor : SealColor.values()) {
			if (color.equalsIgnoreCase(sealColor.color().getColor())) {
				sColor = sealColor;
				break;
			}
		}
		return SEAL.addTemplateSeal(accountId, template, sColor, hText, qText);

	}

}
