package com.foodapp.foodapp.dto;
import java.io.Serializable;






	public class AdminDTO implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String userid;
		private String password;

		public String getUserId() {
			return userid;
		}

		public void setUserId(String userid) {
			this.userid = userid;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
			AdminDTO other = (AdminDTO) obj;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (userid == null) {
				if (other.userid != null)
					return false;
			} else if (!userid.equals(other.userid))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "AdminDTO [userid=" + userid + ", password=" + password + "]";
		}

	}


