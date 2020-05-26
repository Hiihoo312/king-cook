package cooking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cooking.dto.ProductInfo;

/**
 * インターフェスのマッパークラスです.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Mapper //Mapper.xmlを呼ぶ
public interface ProductInfoMapper {

	/**
	 * DBから商品情報を全てセレクトし、一覧画面に表示するメソッドです.
	 * @return 全商品情報。
	 */
	List<ProductInfo> getProductInfoList();

	/**
	 * 商品IDを基にDBから商品情報をセレクト、更新画面のテキストボックスに表示するメソッドです.
	 * @param productID 商品ID。
	 * @return 選択したIDに基づいた商品情報。
	 */
	ProductInfo getProductInfo(Integer productID);

	/**
	 * 商品情報登録メソッド.
	 * @param productInfo 商品情報。
	 */
	void insertProductInfo(ProductInfo productInfo);

	/**
	 * 商品情報更新メソッド.
	 * @param productInfo 商品情報。
	 * @return 更新した商品情報。
	 */
	Integer updateProductInfo(ProductInfo productInfo);

	/**
	 * 商品情報削除メソッド.
	 * @param productInfo 商品情報。
	 * @return 選択された商品情報。
	 */
	Integer deleteProductInfo(ProductInfo productInfo);
}
