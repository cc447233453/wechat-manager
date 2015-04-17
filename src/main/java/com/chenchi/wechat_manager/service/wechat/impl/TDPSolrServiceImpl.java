package com.chenchi.wechat_manager.service.wechat.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.BinaryRequestWriter;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.springframework.stereotype.Service;

import com.chenchi.wechat_manager.dao.WMConfigDao;
import com.chenchi.wechat_manager.entity.TDPoetry;
import com.chenchi.wechat_manager.entity.WMConfig;
import com.chenchi.wechat_manager.service.wechat.TDPSolrService;
@Service
public class TDPSolrServiceImpl implements TDPSolrService {
	@Resource
	private WMConfigDao wmConfigDao;
	private HttpSolrServer server;
	@Override
	public List<TDPoetry> getIndex(String key) throws SolrServerException, IOException {
		List<TDPoetry> list = new ArrayList<TDPoetry>();
		WMConfig wmConfig = wmConfigDao.findByConfigKey("solrUrl");
		String solrUrl = wmConfig.getConfigValue();
		System.out.println("----" + solrUrl);
		if ("".equals(solrUrl) || solrUrl == null) {
			return null;
		}
		server = new HttpSolrServer(solrUrl);
		server.setRequestWriter(new BinaryRequestWriter());
		SolrQuery query = new SolrQuery();
		String queryParse = "poetry:" + key;
		query.setQuery(queryParse);
		// query.setQuery("pAuthor:" + key);
		// query.setQuery("pContent:" + key);
		// query.setStart(0);
		// query.setRows(10);
		QueryResponse queryResponse = server.query(query);
		Iterator<SolrDocument> iter = queryResponse.getResults().iterator();
		System.out.println("******" + queryResponse.getResults().size());
		while (iter.hasNext()) {
			TDPoetry t = new TDPoetry();
			SolrDocument resultDoc = iter.next();

			String pName = (String) resultDoc.getFieldValue("pName");
			String pAuthor = (String) resultDoc.getFieldValue("pAuthor");
			String id = (String) resultDoc.getFieldValue("id"); // id is the
																// uniqueKey
																// field
																//
			// if (queryResponse.getHighlighting().get(id) != null) {
			// List<String> highlightSnippets =
			// queryResponse.getHighlighting().get(id).get("content");
			// }
			t.setpName(pName);
			t.setpAuthor(pAuthor);
			t.setSolrId(Integer.parseInt(id));
			list.add(t);
		}
		return list;
	}

}
