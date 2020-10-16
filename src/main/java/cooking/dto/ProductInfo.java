package cooking.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import cooking.validation.FileSpell;
import cooking.validation.PicFileFormat;
import cooking.validation.PicSize;
import lombok.Data;

/**
 * 商品情報一時保存するBEANクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Data
public class ProductInfo implements Serializable {

	/** シリアルバージョンUID.*/
	private static final long serialVersionUID = -6180752307345718566L;

	/** 商品ID.*/
	private Integer productId;

	/** 商品ジャンル.*/
	private String genre;

	/** 商品メーカー.*/
	@NotEmpty
	@Size(max = 20)
	private String maker;

	/** 商品名.*/
	@NotEmpty
	@Size(max = 25)
	private String productName;

	/** 販売価格.*/
	@NotNull
	@DecimalMax(value = "99999999")
	@DecimalMin(value = "1")
	private BigDecimal sellingPrice;

	/** データベースに保存する為のVARBINARY型バイナリデータの商品画像.*/
	private byte[] productImg;

	/** 画面表示する為の商品画像変数.*/
	private String stringImg;

	/** 画像データの取得とバイナリ変換する為の変数.*/
	@FileSpell(maxWordsNumber = 15)
	@PicFileFormat
	@PicSize(maxSize = 512000)
	private MultipartFile multipartFile;

	/** 商品説明.*/
	@Size(max = 200)
	private String productDetail;

	/** データ更新日時.*/
	private String updateDate;

	/** データ削除フラグ.*/
	private String deleteFlg;

	/** データ登録日時.*/
	private String insertDate;
}