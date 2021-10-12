package model;

import java.util.List;

import dao.ShopDAO;

public class updateLogic {
	
	public List<productInfo> update() {
		ShopDAO dao = new ShopDAO();
		List<productInfo> Shohin_List = dao.update();
		return Shohin_List;
	} 
	public boolean execute(productInfo  productinfo2) {
		ShopDAO dao = new ShopDAO();
		boolean shingi = dao.updateInput(productinfo2);
		return shingi;
	} 

}

