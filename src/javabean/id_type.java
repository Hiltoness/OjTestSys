package javabean;

public class id_type {
	private int id;
	private String type;
	
	public id_type(int id,String type) {
		super();
		this.id=id;
		this.type=type;
	}
	
	public int getId() {
		return id;
	}
	//public void setId(int id) {
	//	this.id=id;
	//}
	public String getType() {
		return type;
	}
	//public void setType(String type) {
	//	this.type=type;
	//}
	
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
