package vip.epss.service.impl;

import org.springframework.stereotype.Service;
import vip.epss.domain.Attributes;
import vip.epss.service.AttributesService;

@Service(value="attributesService")
public class AttributesServiceImpl implements AttributesService {
	@Override
	public void setUserId(Integer id) {
		Attributes.setUserId(id);
	}
	
	@Override
	public Integer getUserId() {
		return Attributes.getUserId();
	}
	
	@Override
	public void setAdminId(Integer id) {
		Attributes.setAdminId(id);
	}
	
	@Override
	public Integer getAdminId() {
		return Attributes.getAdminId();
	}
	
	@Override
	public void setPostId(Integer id) {
		Attributes.setPostId(id);
	}
	
	@Override
	public Integer getPostId() {
		return Attributes.getPostId();
	}
}
