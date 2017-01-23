package model;



/**
 * TabKhinfo generated by MyEclipse - Hibernate Tools
 */

public class TbKhinfo  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;


    // Fields    客户表格

     private String id;
     private String khname;
     private String jian;
     private String address;
     private String bianma;
     private String tel;
    // private String fax;
     private String lian;
     private String ltel;
     private String mail;
     private String xinhang;
     private String hao;


    // Constructors

    /** default constructor */
    public TbKhinfo() {
    }

	/** minimal constructor */
    public TbKhinfo(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public TbKhinfo(String id, String khname, String jian, String address, String bianma, String tel, String fax, String lian, String ltel, String mail, String xinhang, String hao) {
        this.id = id;
        this.khname = khname;
        this.jian = jian;
        this.address = address;
        this.bianma = bianma;
        this.tel = tel;
        //this.fax = fax;
        this.lian = lian;
        this.ltel = ltel;
        this.mail = mail;
        this.xinhang = xinhang;
        this.hao = hao;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getKhname() {
        return this.khname;
    }
    
    public void setKhname(String khname) {
        this.khname = khname;
    }

    public String getJian() {
        return this.jian;
    }
    
    public void setJian(String jian) {
        this.jian = jian;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getBianma() {
        return this.bianma;
    }
    
    public void setBianma(String bianma) {
        this.bianma = bianma;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

  /*  public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
*/
    public String getLian() {
        return this.lian;
    }
    
    public void setLian(String lian) {
        this.lian = lian;
    }

    public String getLtel() {
        return this.ltel;
    }
    
    public void setLtel(String ltel) {
        this.ltel = ltel;
    }

    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getXinhang() {
        return this.xinhang;
    }
    
    public void setXinhang(String xinhang) {
        this.xinhang = xinhang;
    }

    public String getHao() {
        return this.hao;
    }
    
    public void setHao(String hao) {
        this.hao = hao;
    }
   








}