package model;

import java.io.Serializable;

public class category implements Serializable{
	//カテゴリーテーブル
	
	private int catecode;	//カテゴリーコード
	private String cate1;	//カテゴリー名
	
	//コンストラクタ
	public category() {}


	public int getCatecode() {return catecode;}
	public void setCatecode(int catecode) {this.catecode = catecode;}
	public String getCate1() {return cate1;}
	public void setCate1(String cate1) {this.cate1 = cate1;}

}
