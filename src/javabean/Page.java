package javabean;
//卜加慧专属，不要动
public class Page {

	int start;		// 开始数据的索引
	int count;		// 每一页的数量
	int total;		// 总共的数据量

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	 //判断是否有上一页
	public boolean isHasPreviouse(int start){
		if(start==0) {
			return false;
		}else {
			return true;
		}
	}
	
	 //判断是否有下一页

	public boolean isHasNext(int start,int total,int count){
		if(start==getLast(total, count)) {
			return false;
		}else {
			return true;
		}		
}

	 //计算得到总页数

	public int getTotalPage(int total,int count){
		int totalPage;
		// 假设总数是50，是能够被5整除的，那么就有10页
		if (0 == total % count) {
			totalPage = total /count;
			// 假设总数是51，不能够被5整除的，那么就有11页
		}			
		else {
			totalPage = total / count + 1;
		}			
		if(0==totalPage) {
			totalPage = 1;
		}			
		return totalPage;
	}

       // 计算得到尾页

	public int getLast(int total,int count){
		int last;
		// 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		if (0 == total % count) {
			last = total - count;
			// 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
		}		
		else {
			last = total - total % count;
		}
		return last;
	}

}
