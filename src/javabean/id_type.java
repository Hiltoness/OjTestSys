package javabean;

public class id_type {
	private int id;
	private String type;
	private String title;
	private String select_A;
	private String select_B;
	private String select_C;
	private String select_D;

//	public id_type(int id,String type) {
//		super();
//		this.id=id;
//		this.type=type;
//		
//		
//	}
//	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSelect_A() {
		return select_A;
	}

	public void setSelect_A(String select_A) {
		this.select_A = select_A;
	}

	public String getSelect_B() {
		return select_B;
	}

	public void setSelect_B(String select_B) {
		this.select_B = select_B;
	}

	public String getSelect_C() {
		return select_C;
	}

	public void setSelect_C(String select_C) {
		this.select_C = select_C;
	}

	public String getSelect_D() {
		return select_D;
	}

	public void setSelect_D(String select_D) {
		this.select_D = select_D;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj){				
			return true;
		}
		if (obj == null){
			return false;				
		}
		if (getClass() != obj.getClass()){				
			return false;
		}
		id_type sub = (id_type) obj;
		if (sub.getType() == null) {
			return false;
		}
		if (type == null) {
			if (sub.getType() != null){					
				return false;
			}
		} else if (!type.equals(sub.getType())){				
			return false;
		}
		return true;
	}

}
