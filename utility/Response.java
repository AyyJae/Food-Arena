package com.foodapp.foodapp.utility;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class Response implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object data;
	private String message;
	private HttpStatus httpStatus;
	private StatusResponse statusResponse;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public StatusResponse getStatusResponse() {
		return statusResponse;
	}
	public void setStatusResponse(StatusResponse statusResponse) {
		this.statusResponse = statusResponse;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((httpStatus == null) ? 0 : httpStatus.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((statusResponse == null) ? 0 : statusResponse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (httpStatus != other.httpStatus)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (statusResponse != other.statusResponse)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Response [data=" + data + ", message=" + message + ", httpStatus=" + httpStatus + ", statusResponse="
				+ statusResponse + "]";
	}
	
	
}
