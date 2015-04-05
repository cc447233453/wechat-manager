package com.chenchi.wechat_manager.controller.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenchi.wechat_manager.entity.DataDictionary;
import com.chenchi.wechat_manager.service.wechat.DataDictionaryService;

@Controller
@RequestMapping("/manager/")
public class DataDictionaryController {
	@Resource
	private DataDictionaryService dataDictionaryService;
	@RequestMapping("managerDataDic")
	public String managerDataDic() {
		return "manager/dataDictionaryManager";
	}
	@RequestMapping("queryDataDic")
	@ResponseBody
	public List<DataDictionary> queryDataDic() {
		return dataDictionaryService.getList();
	}
	@RequestMapping("addDataDicPre")
	public String addDataDicPre() {
		return "manager/dataDicAdd";
	}
	@RequestMapping("saveDataDic")
	@ResponseBody
	public Map<String, Object> saveDataDic(HttpServletRequest request, DataDictionary dataDic) {
		Map<String, Object> map = new HashMap<String, Object>();
		dataDictionaryService.saveDataDic(dataDic);
		map.put("errorMsg", false);
		return map;
	}
}
