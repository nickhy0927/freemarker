package com.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.ObjectWrapper;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * Created by huangyuan on 16-4-28.
 */
public class UserDirective implements TemplateDirectiveModel {

	public static List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

	static {
		for (int i = 1; i <= 1000; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", i);
			map.put("name", "zhangsan-" + i);
			map.put("password", Math.floor(Math.random() * 100000) + i);
			dataList.add(map);
		}
	}

	@SuppressWarnings("rawtypes")
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {

		// ---------------------------------------------------------------------
		// 处理参数
		int countParam = 0;
		boolean hrParam = false;
		Iterator<?> paramIter = params.entrySet().iterator();
		while (paramIter.hasNext()) {
			Map.Entry ent = (Map.Entry) paramIter.next();
			String paramName = (String) ent.getKey();
			System.out.println(paramName);
			TemplateModel paramValue = (TemplateModel) ent.getValue();
			env.setVariable("username", paramValue);
		}
		System.out.println(params.get("pageSize"));
		System.out.println(params.get("pageNo"));
		int pageNum = params.get("pageNo") != null ? Integer.parseInt(params.get("pageNo").toString()) : 1;
		int pageSize = params.get("pageSize") != null ? Integer.parseInt(params.get("pageSize").toString()) : 10;
		if (loopVars.length > 1) {
			throw new TemplateModelException("At most one loop variable is allowed.");
		}
		List<Map<String, Object>> dataLists = new ArrayList<Map<String, Object>>();
		int endPos = pageNum * pageSize;
		for (int i = 0; i < dataList.size(); i++) {
			if (params.get("userName") != null) {
				if (!dataList.get(i).get("name").toString().contains(params.get("userName").toString())) {
					dataList.remove(i);
				}
			}
		}
		endPos = endPos > dataList.size() ? dataList.size() : endPos;
		for (int i = (pageNum - 1) * pageSize; i < endPos; i++) {
			dataLists.add(dataList.get(i));
		}
		env.setVariable("recordCount", ObjectWrapper.DEFAULT_WRAPPER.wrap(dataList.size()));
		env.setVariable("url", ObjectWrapper.DEFAULT_WRAPPER.wrap("/toHome"));
		env.setVariable("dataList", ObjectWrapper.DEFAULT_WRAPPER.wrap(dataLists));
		Writer out = env.getOut();
		if (body != null) {
			for (int i = 0; i < countParam; i++) {
				// 输出 <hr> 如果 参数hr 设置为true
				if (hrParam && i != 0) {
					out.write("<hr>");
				}

				// 设置循环变量
				if (loopVars.length > 0) {
					loopVars[0] = new SimpleNumber(i + 1);
				}
				// 执行标签内容(same as <#nested> in FTL).
				body.render(env.getOut());
			}
		}
	}

}
