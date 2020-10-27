package cooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cooking.dto.ProductInfo;
import cooking.mapper.ProductInfoMapper;

/**
 * インターフェースのサービスクラスです.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Service
public class ProductInfoService {

	/** productInfoMapper インターフェース.*/
	@Autowired
	ProductInfoMapper productInfoMapper;

	/**
	 * インターフェースを呼んで、全商品情報を取得するメソッド.
	 * @return 全商品情報。
	 */
	public List<ProductInfo> getProductInfoList() {
		return productInfoMapper.getProductInfoList();
	}

	/**
	 * インターフェースを呼んで、商品情報を登録するメソッド.
	 * @param productInfo 商品情報。
	 */
	@Transactional
	public void insertProductInfo(ProductInfo productInfo) {
		productInfoMapper.insertProductInfo(productInfo);
	}

	/**
	 * インターフェースを呼んで、選択したIDに基づいた商品情報を取得するメソッド.
	 * @param productId 選択した商品ID。
	 * @return 選択したIDに基づいた商品情報。
	 */
	public ProductInfo getProductInfo(Integer productId) {
		return productInfoMapper.getProductInfo(productId);
	}

	/**
	 * インターフェースを呼んで、商品情報を更新するメソッド.
	 * @param productInfo 商品情報。
	 * @return 更新件数。
	 */
	@Transactional
	public Integer updateProductInfo(ProductInfo productInfo) {
		return productInfoMapper.updateProductInfo(productInfo);
	}

	/**
	 * インターフェースを呼んで、商品情報を削除する（論理削除）メソッド.
	 * @param productInfo 商品情報。
	 * @return 削除件数。
	 */
	@Transactional
	public Integer deleteProductInfo(ProductInfo productInfo) {
		return productInfoMapper.deleteProductInfo(productInfo);
	}
}
