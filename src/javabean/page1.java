package javabean;

public class page1 {
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
