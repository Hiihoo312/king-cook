package cooking.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.GroupSequence;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import validation.CheckGroups.CheckGroup1;
import validation.CheckGroups.CheckGroup2;
import validation.CheckGroups.CheckGroup3;
import validation.FileSpell;
import validation.PicFileFormat;
import validation.PicSize;

/**
 * 商品情報一時保存するBEANクラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Data

public class ProductInfo implements Serializable {
	@GroupSequence({ CheckGroup1.class, CheckGroup2.class, CheckGroup3.class })
	public interface All {
	}

	/** 商品ID.*/
	private Integer productID;

	/** 商品ジャンル.*/
	private String genre;

	/** 商品メーカー.*/
	// リクエストパラメータとしてmakerが存在するかどうかをチェック。
	@NotEmpty(groups = CheckGroup1.class)
	@Size(max = 20, groups = CheckGroup1.class)
	private String maker;

	/** 商品名.*/
	// リクエストパラメータとしてproductNameが存在するかどうかをチェック。
	@NotEmpty(groups = CheckGroup1.class)
	@Size(max = 25, groups = CheckGroup1.class)
	private String productName;

	/** 販売価格.*/
	@DecimalMax(value = "100000000", inclusive = false, groups = CheckGroup1.class)
	@DecimalMin(value = "1", inclusive = true, groups = CheckGroup1.class)
	private BigDecimal sellingPrice;

	/** データベースに保存する為のVARBINARY型バイナリデータの商品画像.*/
	@NotNull
	private byte[] productImg;

	/** 画面表示する為の商品画像変数.*/
	private String stringImg;

	/** 画像データの取得とバイナリ変換する為の変数.*/
	@FileSpell(maxWordsNumber = 16, groups = CheckGroup1.class)
	@PicFileFormat(groups = CheckGroup1.class)
	@PicSize(groups = CheckGroup1.class)
	private MultipartFile multipartFile;

	/** 商品説明.*/
	@Size(min = 1, max = 200, groups = CheckGroup1.class)
	private String productDetail;

	/** データ更新日時.*/
	private String updateDate;

	/** データ削除フラグ.*/
	private String deleteFlg;

	/** データ登録日時.*/
	private String insertDate;

	/** 現在時刻.*/
	private String CURRENT_TIMESTAMP;

}
