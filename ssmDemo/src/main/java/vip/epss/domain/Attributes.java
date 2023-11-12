package vip.epss.domain;

public class Attributes {
	public static Integer userId;
	public static Integer postId;
	public static Integer adminId;
	
	public static Integer getUserId() {
		return userId;
	}
	
	public static void setUserId(Integer userId) {
		Attributes.userId = userId;
	}
	
	public static Integer getPostId() {
		return postId;
	}
	
	public static void setPostId(Integer postId) {
		Attributes.postId = postId;
	}
	
	public static Integer getAdminId() {
		return adminId;
	}
	
	public static void setAdminId(Integer adminId) {
		Attributes.adminId = adminId;
	}
}
