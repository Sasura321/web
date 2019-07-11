/**
 * 需求：设计一个工具对象ArrayUtil中添加一个
				search(array,target) 
 在array数组中查找target元素的位置
 添加要给max(array) ;获取最大值
 */

//定义这样一个对象
function ArrayUtil(){
	//追加方法
	this.search = function(array,target) {
		//遍历数组
		for(var i = 0; i<array.length; i++) {
			if(array[i]==target) {
				return i;
			}
		}
		
		//找不到,返回-1
		return -1;
	}
	
	this.max = function(array) {
		var max = array[0];
		for(var i=1; i<array.length; i++) {
			if(array[i]>max) {
				max = array[i];
			}
		}
		return max;
	}
}
