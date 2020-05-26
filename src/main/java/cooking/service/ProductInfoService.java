package cooking.service;

import java.io.Serializable;
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
public class ProductInfoService implements Serializable {

	/** productInfoMapper.*/
	@Autowired
	ProductInfoMapper productInfoMapper;

	/**
	 * productInfoMapper.getProductInfoList()を呼ぶメソッド.
	 * @return productInfoMapper.getProductInfoList()。
	 */
	@Transactional
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
	 * @return productInfoMapper.getProductInfo(productID)。
	 */
	@Transactional
	public ProductInfo getProductInfo(Integer productID) {
		return productInfoMapper.getProductInfo(productID);
	}

	/**
	 * productInfoMapper.updateProductInfo(productInfo)を呼ぶメソッド.
	 * @param productInfo 商品情報。
	 * @return productInfoMapper.updateProductInfo(productInfo)。
	 */
	@Transactional
	public Integer updateProductInfo(ProductInfo productInfo) {
		return productInfoMapper.updateProductInfo(productInfo);

	}

	/**
	 * productInfoMapper.deleteProductInfo(productInfo)を呼ぶメソッド.
	 * @param productInfo 商品情報。
	 * @return productInfoMapper.deleteProductInfo(productInfo)。
	 */
	@Transactional
	public Integer deleteProductInfo(ProductInfo productInfo) {
		return productInfoMapper.deleteProductInfo(productInfo);
	}
}