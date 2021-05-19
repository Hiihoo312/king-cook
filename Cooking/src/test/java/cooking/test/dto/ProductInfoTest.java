package cooking.test.dto;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import cooking.dto.ProductInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
/**
 * 商品情報一時保存するBEANクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
public class ProductInfoTest {
	/*public class ProductInfoTest implements Serializable {*/
	@Autowired
	Validator validator;

	private ProductInfo productInfo = new ProductInfo();
	private BindingResult bindingResult = new BindException(productInfo, "ProductInfo");

	@Before
	public void before() throws Exception {
		productInfo.setMaker("ok");
		productInfo.setProductName("h");
	}

	/*エラーなし*/
	@Test
	public void noError() throws Exception {
		validator.validate(productInfo, bindingResult);
		assertThat(bindingResult.getFieldError(), is(nullValue()));
	}
	/*
		*//**
			* makerがnull
			*/
	/*
	@Test
	public void makerIsNull() throws Exception {
	productInfo.setMaker(null);
	validator.validate(productInfo, bindingResult);
	assertThat(bindingResult.getFieldError().getField(), is("maker"));
	assertThat(bindingResult.getFieldError().getDefaultMessage(), is("{0}の入力は必須です。"));
	}

	*//**
		* productNameがnull
		*//*
			@Test
			public void productNameIsNull() throws Exception {
			productInfo.setProductName(null);
			validator.validate(productInfo, bindingResult);
			assertThat(bindingResult.getFieldError().getField(), is("productName"));
			assertThat(bindingResult.getFieldError().getDefaultMessage(), is("{0}の入力は必須です。"));
			}
			*/
}
