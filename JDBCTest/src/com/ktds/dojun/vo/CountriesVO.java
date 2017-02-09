package com.ktds.dojun.vo;

public class CountriesVO {

	private String countryId;
	private String contryName;
	private int regionID;
	private RegionsVO regionsVO;
	
	
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getContryName() {
		return contryName;
	}
	public void setContryName(String contryName) {
		this.contryName = contryName;
	}
	public int getRegionID() {
		return regionID;
	}
	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}
	
	public RegionsVO getRegionsVO() {
		if(regionsVO == null){
			regionsVO = new RegionsVO();
		}
		return regionsVO;
	}
	
	public void setRegionsVO(RegionsVO regionsVO) {
		this.regionsVO = regionsVO;
	}
	
	
	
	
}
