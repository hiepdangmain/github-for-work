package com.msb.ibs.common.request;

import org.springframework.web.multipart.MultipartFile;

import com.msb.ibs.common.dto.UserPrincipal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalUploadFileRequest {
	private MultipartFile part;
	private UserPrincipal userPrincipal;
	private String token;
	private String language;
	private String channel;

	public InternalUploadFileRequest(MultipartFile part, UserPrincipal userPrincipal, String token) {
		this.part = part;
		this.userPrincipal = userPrincipal;
		this.token = token;
	}

	public InternalUploadFileRequest(MultipartFile part, UserPrincipal userPrincipal, String token, String channel) {
		this.part = part;
		this.userPrincipal = userPrincipal;
		this.token = token;
		this.channel = channel;
	}
}
