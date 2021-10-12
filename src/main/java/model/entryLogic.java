package model;

import dao.ShopDAO;

public class entryLogic {
	
	public boolean execute(productInfo  productinfo) {
		ShopDAO dao = new ShopDAO();
		boolean shingi = dao.entryInput(productinfo);
		return shingi;
	} 

}
