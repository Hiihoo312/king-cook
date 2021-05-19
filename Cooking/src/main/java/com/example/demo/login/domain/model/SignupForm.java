package com.example.demo.login.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	//@NotBlank
	//パターン5以外↑
	//	@NotBlank(groups = ValidGroup1.class, message="{require_check}")
	@NotBlank
	//@Email
	//パターン5以外↑
	//	@Email(groups = ValidGroup2.class, message="{email_check}")
	@Email
	private String userId; //ユーザーID

	//@NotBlank
	//パターン5以外↑
	//	@NotBlank(groups = ValidGroup1.class, message="{require_check}")
	@NotBlank
	//@Length(min = 4, max = 100)
	//パターン5以外↑
	//	@Length(groups = ValidGroup2.class, min = 4, max = 100, message="{length_check}")
	@Length(min = 4, max = 100)
	//@Pattern(regexp = "^[a-zA-Z0-9]+$")
	//パターン5以外↑
	//	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup3.class, message="{pattern_check}")
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password; //パスワード

	//@NotBlank
	//パターン5以外↑
	//	@NotBlank(groups = ValidGroup1.class,message="{require_check}")
	@NotBlank
	private String userName; //ユーザー名

	//@NotNull
	//パターン5以外↑
	//	@NotNull(groups = ValidGroup1.class, message="{require_check}")
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday; //誕生日

	//@Min(20)
	//パターン5以外↑
	//	@Min(groups = ValidGroup2.class, value=20, message="{min_check}")
	@Min(value = 20)
	//@Max(100)
	//パターン5以外↑
	//	@Max(groups = ValidGroup2.class, value=100, message="{max_check}")
	@Max(value = 100)
	private int age; //年齢

	//@AssertFalse
	//パターン5以外↑
	//	@AssertFalse(groups = ValidGroup2.class, message="{false_check}")
	@AssertFalse
	private boolean marriage; //結婚ステータス

}
