/**
 * $Id: ProtocolHeader.java 1034 2012-11-22 09:39:58Z yang.guo $
 * Copyright(C) 2011-2016 dreamingame.com All rights reserved.
 */
package parser;

/**
 * 
 * @author <a href="mailto:shiyang.zhao@dreamingame.com">Rex Zhao</a>
 * @version 1.0 2012-2-20 下午11:55:53
 */
public class ProtocolHeader {

    private String deviceType;
    private String deviceVersion;
    private String deviceId;
    private String locale;
    private String version;
    private long timestamp;
    private String playerKey;
    private String deviceFamily;
    private String mac;
    private int server;
    private int protocolCount;
//    private int purchaseType;
    private String channelCode;
    private String storeName;
    
    private String localeZone;
    private String resolution;
    private String sk;
    
    @Override
	public String toString() {
        return "\ndeviceType:" + deviceType + "\ndeviceVer:" + deviceVersion + "\ndeviceId:" + deviceId +
               "\nlocale:" + locale + "\nversion:" + version + 
               "\ntimestamp:" + timestamp + "\nplayerKey:" + playerKey + "\ndeviceFamily:" + deviceFamily + 
               "\nmac:" + mac + "\nserver:" + server + "\nprotocolCount:" + protocolCount + "\nchannelCode:" + channelCode +
               "\nstoreName:" + storeName + "\nlocaleZone:" + localeZone + "\nresolution:" + resolution + "\nsk:" + sk;
    }
    
	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getPlayerKey() {
		return playerKey;
	}

	public void setPlayerKey(String playerKey) {
		this.playerKey = playerKey;
	}

	public String getDeviceFamily() {
		return deviceFamily;
	}

	public void setDeviceFamily(String deviceFamily) {
		this.deviceFamily = deviceFamily;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public int getServer() {
		return server;
	}

	public void setServer(int server) {
		this.server = server;
	}

	public int getProtocolCount() {
		return protocolCount;
	}

	public void setProtocolCount(int protocolCount) {
		this.protocolCount = protocolCount;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLocaleZone() {
		return localeZone;
	}

	public void setLocaleZone(String localeZone) {
		this.localeZone = localeZone;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSk() {
		return sk;
	}

	public void setSk(String sk) {
		this.sk = sk;
	}
}
