package cooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cooking.dto.ProductInfo;
import cooking.mapper.ProductInfoMapper;

/**
 * インターフェスのサービスクラスです.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Service
public class ProductInfoService {

	/** productInfoMapper.*/
	@Autowired
	ProductInfoMapper productInfoMapper;

	/**
	 * productInfoMapper.getProductInfoList()を呼ぶメソッド.
	 * @return 全商品情報。
	 */
	public List<ProductInfo> getProductInfoList() {
		return productInfoMapper.getProductInfoList();
	}

	/**
	 * productInfoMapper.insertProductInfo(productInfo)を呼ぶメソッド.
	 * @param productInfo 商品情報。
	 */
	@Transactional
	public void insertProductInfo(ProductInfo productInfo) {
		productInfoMapper.insertProductInfo(productInfo);
	}

	/**
	 * productInfoMapper.getProductInfo(productID)を呼ぶメソッド.
	 * @param productID 選択した商品ID。
	 * @return 選択したIDに基づいた商品情報。
	 */
	public ProductInfo getProductInfo(Integer productID) {
		return productInfoMapper.getProductInfo(productID);
	}

	/**
	 * productInfoMapper.updateProductInfo(productInfo)を呼ぶメソッド.
	 * @param productInfo 商品情報。
	 * @return 更新した商品情報。
	 */
	@Transactional
	public Integer updateProductInfo(ProductInfo productInfo) {
		return productInfoMapper.updateProductInfo(productInfo);

	}

	/**
	 * productInfoMapper.deleteProductInfo(productInfo)を呼ぶメソッド.
	 * @param productInfo 商品情報。
	 * @return 更新した商品情報（論理削除）。
	 */
	@Transactional
	public Integer deleteProductInfo(ProductInfo productInfo) {
		return productInfoMapper.deleteProductInfo(productInfo);
	}
}