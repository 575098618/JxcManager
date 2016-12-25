package model;

/**
 * TabGysinfo generated by MyEclipse - Hibernate Tools
 */
// Fields 供应商表格

public class TbGysinfo implements java.io.Serializable {

	/**
	 * 为Java序列化机制划分版本，实现java.io.Serializable这个接口是为序列化, //serialVersionUID
	 * 用来表明实现序列化类的不同版本间的兼容性。(兼容性问题) //如果你修改了此类, 要修改此值。否则以前用老版本的类序列化的类恢复时会出错
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 1、java.io.Serializable，表示序列化，是一个空接口，
	 * 也就是说这个接口没有声明任何的方法，所以实现这个接口的类也就不需要实现任何的方法。
	 * 2、之所以需要对象序列化，是因为有时候对象需要在网络上传输，传输的时候需要这种序列化处理，
	 * 从服务器硬盘上把序列化的对象取出，然后通过网络传到客户端，再由客户端把序列化的对象读入内存， 执行相应的处理。
	 * （方便在网络上传输，需要序列化处理，序列化，增加实体在数据库和内存之间的传送速度 ）
	 */

	private String id;
	private String name;
	private String jc;
	private String address;
	private String bianma;
	private String tel;
	private String fax;
	private String lian;
	private String ltel;
	private String yh;
	private String mail;

	// Constructors

	/** default constructor */
	public TbGysinfo() {
	}

	/** minimal constructor */
	public TbGysinfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public TbGysinfo(String id, String name, String jc, String address, String bianma, String tel, String fax,
			String lian, String ltel, String yh, String mail) {
		this.id = id;
		this.name = name;
		this.jc = jc;
		this.address = address;
		this.bianma = bianma;
		this.tel = tel;
		this.fax = fax;
		this.lian = lian;
		this.ltel = ltel;
		this.yh = yh;
		this.mail = mail;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJc() {
		return this.jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
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

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

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

	public String getYh() {
		return this.yh;
	}

	public void setYh(String yh) {
		this.yh = yh;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}