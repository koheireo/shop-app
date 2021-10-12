package model;
import java.io.Serializable;
public class LST implements Serializable{
	private int ID=0;
	private boolean ADMIN;
	private String USERID;
	private String PASS;
	private String NAME0;
	private String NAME1;
	private String NAME2;
	private String MAILADD;
	private String POSTNUM;
	private String ADDRESS0;
	private String ADDRESS1;
	private String ADDRESS2;
	private String TELNUM;


		public LST() {}

	public LST(int id, boolean admin, String userid, String pass) {
		this.ID = id;
		this.ADMIN = admin;
		this.USERID = userid;
		this.PASS = pass;
	}

	public LST(int id, boolean admin, String userid, String pass, String name0, String name1,
			String name2, String mailadd, String postnum, String address0, String address1,
			String address2, String telnum) {
		this.ID = id;
		this.ADMIN = admin;
		this.USERID = userid;
		this.PASS = pass;
		this.NAME0 = name0;
		this.NAME1 = name1;
		this.NAME2 = name2;
		this.MAILADD = mailadd;
		this.POSTNUM = postnum;
		this.ADDRESS0 = address0;
		this.ADDRESS1 = address1;
		this.ADDRESS2 = address2;
		this.TELNUM = telnum;
	}

	/**
	 * @return iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return aDMIN
	 */
	public boolean isADMIN() {
		return ADMIN;
	}

	/**
	 * @return uSERID
	 */
	public String getUSERID() {
		return USERID;
	}

	/**
	 * @return pASS
	 */
	public String getPASS() {
		return PASS;
	}

	/**
	 * @return nAME0
	 */
	public String getNAME0() {
		return NAME0;
	}

	/**
	 * @return nAME1
	 */
	public String getNAME1() {
		return NAME1;
	}

	/**
	 * @return nAME2
	 */
	public String getNAME2() {
		return NAME2;
	}

	/**
	 * @return mAILADD
	 */
	public String getMAILADD() {
		return MAILADD;
	}

	/**
	 * @return pOSTNUM
	 */
	public String getPOSTNUM() {
		return POSTNUM;
	}

	/**
	 * @return aDDRESS0
	 */
	public String getADDRESS0() {
		return ADDRESS0;
	}

	/**
	 * @return aDDRESS1
	 */
	public String getADDRESS1() {
		return ADDRESS1;
	}

	/**
	 * @return aDDRESS2
	 */
	public String getADDRESS2() {
		return ADDRESS2;
	}

	/**
	 * @return tELNUM
	 */
	public String getTELNUM() {
		return TELNUM;
	}

	/**
	 * @param aDMIN セットする aDMIN
	 */
	public void setADMIN(boolean aDMIN) {
		ADMIN = aDMIN;
	}

	/**
	 * @param uSERID セットする uSERID
	 */
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	/**
	 * @param pASS セットする pASS
	 */
	public void setPASS(String pASS) {
		PASS = pASS;
	}

	/**
	 * @param nAME0 セットする nAME0
	 */
	public void setNAME0(String nAME0) {
		NAME0 = nAME0;
	}

	/**
	 * @param nAME1 セットする nAME1
	 */
	public void setNAME1(String nAME1) {
		NAME1 = nAME1;
	}

	/**
	 * @param nAME2 セットする nAME2
	 */
	public void setNAME2(String nAME2) {
		NAME2 = nAME2;
	}

	/**
	 * @param mAILADD セットする mAILADD
	 */
	public void setMAILADD(String mAILADD) {
		MAILADD = mAILADD;
	}

	/**
	 * @param pOSTNUM セットする pOSTNUM
	 */
	public void setPOSTNUM(String pOSTNUM) {
		POSTNUM = pOSTNUM;
	}

	/**
	 * @param aDDRESS0 セットする aDDRESS0
	 */
	public void setADDRESS0(String aDDRESS0) {
		ADDRESS0 = aDDRESS0;
	}

	/**
	 * @param aDDRESS1 セットする aDDRESS1
	 */
	public void setADDRESS1(String aDDRESS1) {
		ADDRESS1 = aDDRESS1;
	}

	/**
	 * @param aDDRESS2 セットする aDDRESS2
	 */
	public void setADDRESS2(String aDDRESS2) {
		ADDRESS2 = aDDRESS2;
	}

	/**
	 * @param tELNUM セットする tELNUM
	 */
	public void setTELNUM(String tELNUM) {
		TELNUM = tELNUM;
	}



}
