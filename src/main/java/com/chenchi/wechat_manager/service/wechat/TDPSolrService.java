package com.chenchi.wechat_manager.service.wechat;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.chenchi.wechat_manager.entity.TDPoetry;

public interface TDPSolrService {
	public List<TDPoetry> getIndex(String key) throws SolrServerException, IOException;
}
