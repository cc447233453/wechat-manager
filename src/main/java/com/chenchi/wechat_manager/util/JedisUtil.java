package com.chenchi.wechat_manager.util;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @Description: Jedis存储工具
 * @see: JedisUtil 此处填写需要参考的类
 * @version 2015年4月4日 上午8:17:22
 * @author chenchi
 */
public class JedisUtil {

	private static ShardedJedisPool shardedJedisPool;

	private static ShardedJedisPool getJedisPool() {

		if (shardedJedisPool == null) {
			shardedJedisPool = (ShardedJedisPool) SpringContextUtils.getCurrentContext().getBean("shardedJedisPool");
		}

		return shardedJedisPool;
	}

	/*
	 * 获取
	 */
	public static String getValue(String key) {

		ShardedJedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			String result = jedis.get(key);
			return result;
		} finally {
			if (jedis != null) {
				shardedJedisPool.returnResource(jedis);
			}
		}
	}

	/*
	 * 删除
	 */
	public static void remove(String key) {

		ShardedJedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			jedis.del(key);
		} finally {
			if (jedis != null) {
				shardedJedisPool.returnResource(jedis);
			}
		}
	}

	/*
	 * 存储字符串
	 */
	public static void setKeyValue(String key, String value, int expire) {

		ShardedJedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			jedis.set(key, value);
			if (expire > 0) {
				jedis.expire(key, expire);
			}
		} finally {
			if (jedis != null) {
				shardedJedisPool.returnResource(jedis);
			}
		}
	}

	/*
	 * 存储流
	 */
	public static void setKeyByte(String key, byte[] value, int expire) {

		ShardedJedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			jedis.set(key.getBytes(), value);
			if (expire > 0) {
				jedis.expire(key, expire);
			}
		} finally {
			if (jedis != null) {
				shardedJedisPool.returnResource(jedis);
			}
		}
	}

	/*
	 * 获取流
	 */
	public static byte[] getByte(String key) {

		ShardedJedis jedis = null;
		try {
			jedis = getJedisPool().getResource();
			byte[] result = jedis.get(key.getBytes());
			return result;
		} finally {
			if (jedis != null) {
				shardedJedisPool.returnResource(jedis);
			}
		}
	}

}
